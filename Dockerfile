# Stage 1: Build the application
FROM maven:3.9.2-amazoncorretto-17 AS build

# Set the working directory
WORKDIR /app


# Copy the Maven build files
COPY pom.xml .
COPY src ./src


# Build the application with verbose logging
#RUN mvn clean package -U -DskipTests -X

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the jar file from the build stage
COPY  target/aw-merge-0.0.1-SNAPSHOT.jar /app/aw-merge.jar

# Expose the port the app runs on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "aw-merge.jar"]
