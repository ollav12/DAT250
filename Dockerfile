# Use the official Gradle image as the build stage
FROM gradle:8.9-jdk21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy Gradle build files to the container
COPY settings.gradle.kts build.gradle.kts ./

# Copy the source code to the container
COPY src ./src

# Build the application and create a JAR file
RUN gradle bootJar --no-daemon

# Use a smaller base image for the final stage
FROM openjdk:21-jdk-slim

# Set the working directory for the final image
WORKDIR /app

# Copy the JAR file from the build stage to the final image
COPY --from=build /app/build/libs/*.jar app.jar

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
