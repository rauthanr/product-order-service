# Use a base image with OpenJDK
FROM openjdk:11-jre-slim

# Add the JAR file to the Docker image
COPY build/libs/api-gateway-service-0.0.1.war /app/api-gateway-service-0.0.1.war

# Set the working directory
WORKDIR /app

# Expose the port the application will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "api-gateway-service-0.0.1.war"]
