
# Set the working directory
WORKDIR /app

# Copy the jar file from target to the working directory
COPY target/authService-0.0.1-SNAPSHOT.jar authService.jar

# Expose the port on which the application will run
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "authService.jar"]
