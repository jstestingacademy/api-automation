# Use Maven and JDK as base image
FROM maven:3.9.6-eclipse-temurin-17

# Set working directory inside the container
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy project files
COPY src ./src

# Run tests using Maven
CMD ["mvn", "test"]
