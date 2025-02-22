FROM gradle:8.12.1-jdk21-alpine as menu-service-build-image

VOLUME /tmp
WORKDIR .
COPY ./ ./

RUN ./gradlew build --stacktrace
COPY build/libs/menu-service-0.0.1-SNAPSHOT.jar menu-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/menu-service.jar"]