FROM gradle:8.12.1-jdk21-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src/
RUN gradle build --no-daemon

FROM openjdk:21

EXPOSE 8082

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/clientservice-*-SNAPSHOT.jar app.jar
COPY *.env .env

ENTRYPOINT ["java", "-jar","/app.jar"]