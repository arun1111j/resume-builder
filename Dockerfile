# Stage 1: Build with JDK 21
FROM eclipse-temurin:21-jdk-jammy as builder

WORKDIR /app

# First copy just the wrapper files and make them executable
COPY .mvn/ .mvn
COPY mvnw ./
RUN chmod +x mvnw  

# Then copy POM and download dependencies
COPY pom.xml ./
RUN ./mvnw dependency:go-offline

# Copy source and build
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Stage 2: Run with JRE 21
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.jar"]