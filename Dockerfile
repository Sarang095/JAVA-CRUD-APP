# Use a base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file from target to the working directory
COPY target/crud-v1.jar crud-v1.jar

# Expose the port on which the application will run
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "crud-v1.jar"]
