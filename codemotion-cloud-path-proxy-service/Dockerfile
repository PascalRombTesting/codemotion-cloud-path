FROM adoptopenjdk/openjdk11:latest
RUN mkdir app

COPY target/*.jar app/proxy-service.jar
WORKDIR app

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "proxy-service.jar"]