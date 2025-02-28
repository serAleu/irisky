FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} i-risky-app.jar
ENTRYPOINT ["java","-jar","/i-risky-app.jar"]