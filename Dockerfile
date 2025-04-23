# Stage 1: Build with JDK 21
FROM eclipse-temurin:21-jdk-jammy as builder

WORKDIR /app

# Copy build files separately for better reliability
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable and download dependencies
RUN chmod +x mvnw && \
    ./mvnw dependency:go-offline -B

# Copy source and build
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Stage 2: Runtime with JRE 21
FROM eclipse-temurin:21-jre-jammy

# Add security best practices
RUN apt-get update && \
    apt-get install -y --no-install-recommends curl && \
    rm -rf /var/lib/apt/lists/*

# Create non-root user
RUN addgroup --system spring && \
    adduser --system --ingroup spring spring
USER spring:spring

WORKDIR /app

# Copy built artifact with proper permissions
COPY --from=builder --chown=spring:spring /app/target/*.jar app.jar

# Health check
HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:10000/manage/health || exit 1

# Security headers and JVM optimizations
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75 -Djava.security.egd=file:/dev/./urandom"

EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.jar"]