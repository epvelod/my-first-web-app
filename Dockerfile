FROM amazoncorretto:21
ARG PACKAGE_TOKEN
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/demo.jar
ENV PACKAGE_TOKEN=${PACKAGE_TOKEN}
ENTRYPOINT ["java", "-jar", "demo.jar"]
