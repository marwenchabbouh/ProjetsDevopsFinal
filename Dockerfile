FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} GesF-1.0.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/GesF-1.0.jar"]