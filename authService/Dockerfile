FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/authService-0.0.1-SNAPSHOT.jar ./authService.jar

ENTRYPOINT ["java", "-jar", "authService.jar"]