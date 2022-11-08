FROM openjdk:17-alpine

WORKDIR /api

ADD target/vacina-api-1.0.0.jar /api/vacina-api.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "vacina-api.jar"]

