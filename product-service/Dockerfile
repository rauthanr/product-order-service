# Use a base image with OpenJDK
FROM openjdk:11-jre-slim

# Add the JAR file to the Docker image
COPY build/libs/product-service-0.0.1.jar /app/product-service-0.0.1.jar

# Set the working directory
WORKDIR /app

# Expose the port the application will run on
EXPOSE 8081

# Command to run the application
ENTRYPOINT ["java", "-jar", "product-service-0.0.1.jar"]
