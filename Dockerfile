FROM amazoncorretto:21
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
ENV PACKAGE_TOKEN=${PUBLISHING_TOKEN}
ENTRYPOINT ["java", "-jar", "demo.jar"]
