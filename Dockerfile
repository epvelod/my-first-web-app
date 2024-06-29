FROM amazoncorretto:21
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
ENTRYPOINT ["java", "-jar", "demo.jar"]
