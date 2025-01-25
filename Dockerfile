FROM openjdk:17-jdk-alpine
COPY ./target/springboot-docker.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]