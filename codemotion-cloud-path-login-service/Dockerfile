FROM adoptopenjdk/openjdk11:latest
RUN mkdir app

COPY target/*.jar app/login-service.jar
WORKDIR app

EXPOSE 8070
ENTRYPOINT ["java", "-jar", "login-service.jar"]