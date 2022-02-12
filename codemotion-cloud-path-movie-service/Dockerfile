FROM adoptopenjdk/openjdk11:latest
RUN mkdir app

COPY target/*.jar app/movie-service.jar
WORKDIR app

EXPOSE 8090
ENTRYPOINT ["java", "-jar", "movie-service.jar"]