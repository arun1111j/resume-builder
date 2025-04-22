# Build stage
FROM eclipse-temurin:21-jdk-jammy as builder

WORKDIR /app
COPY mvnw pom.xml .mvn/ .mvn/
RUN chmod +x mvnw && ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:21-jre-jammy

ENV JAVA_OPTS="-XX:MaxRAMPercentage=75 -Dserver.port=10000"
ENV PORT=10000

WORKDIR /app
COPY --from=builder /app/target/resume-builder-*.jar app.jar

RUN useradd -m myuser && chown -R myuser:myuser /app
USER myuser

HEALTHCHECK --interval=30s --timeout=3s \
  CMD curl -f http://localhost:10000/manage/health || exit 1

EXPOSE 10000

ENTRYPOINT ["sh", "-c", "exec java ${JAVA_OPTS} -jar app.jar"]