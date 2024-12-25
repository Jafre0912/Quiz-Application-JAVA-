# Use an official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy all project files into the container
COPY . /app

# Compile the Java files
RUN javac -d out src/*.java

# Run the Java application
CMD ["java", "-cp", "out", "Main"]
