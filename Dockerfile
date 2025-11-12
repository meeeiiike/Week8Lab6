# Build Stage
FROM eclipse-temurin:25-jre AS runtime
WORKDIR /app

# Copy fat jar built by maven
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]