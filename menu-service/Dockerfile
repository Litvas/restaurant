FROM openjdk:21-jdk
VOLUME /tmp
WORKDIR .
COPY ./ ./
COPY build/*.jar menu-service.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","/menu-service.jar"]