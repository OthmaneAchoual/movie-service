FROM openjdk:8-jdk-alpine

RUN apk update && apk add bash

VOLUME /tmp
COPY target/movie-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]