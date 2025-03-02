FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY . /app/.
RUN mvn -f /app/pom.xml clean package -Dmaven.test.skip=true

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
ADD candies.txt /src/main/resources/static/
COPY --from=builder /app/target/*.jar /app/*.jar
EXPOSE 3838
ENTRYPOINT ["java", "-jar", "/app/*.jar"]