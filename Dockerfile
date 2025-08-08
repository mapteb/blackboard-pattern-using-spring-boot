# Stage 2: Create the final image
#FROM gradle:8.0-jdk17 AS builder
FROM eclipse-temurin:17-jdk AS builder

WORKDIR /app
COPY . .

RUN chmod +x gradlew
RUN ./gradlew bootJar

# --- Runtime stage ---
FROM eclipse-temurin:17-jre

WORKDIR /app
#ARG JAR_FILE=/app/build/libs/*.jar
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]