#FROM gradle:8.12.1-jdk21-alpine as menu-service-build-image
#
#WORKDIR .
#COPY ./ ./
#RUN ./gradlew build --stacktrace

FROM eclipse-temurin:21-jre-alpine
WORKDIR .
COPY ./ ./
COPY build/libs/menu-service-*-SNAPSHOT.jar menu-service.jar
COPY .env /menu-service/.env

EXPOSE 8081
ENTRYPOINT ["java","-jar","menu-service.jar"]