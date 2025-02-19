FROM amazoncorretto:21

EXPOSE 9001
WORKDIR /app

COPY target/AppWeb-0.0.1-SNAPSHOT.jar app.jar
CMD ["java", "-jar" ,"app.jar"]
