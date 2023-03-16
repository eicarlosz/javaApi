FROM openjdk:17-alpine

WORKDIR /app/

COPY ../target/api-vacina-1.0.0.jar api-vacina.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "api-vacina.jar"]

