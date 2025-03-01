## Build stage
FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY . /app/.
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

# Package stage
FROM openjdk:17
WORKDIR /app
COPY --from=builder /app/target/*.jar target/*.jar
EXPOSE 3838
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} i-risky-app.jar
CMD ["java", "-jar", "/app/*.jar"]