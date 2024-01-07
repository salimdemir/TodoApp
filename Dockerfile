
FROM openjdk:18
WORKDIR /todo_app
COPY target/todo-0.0.1-SNAPSHOT.jar todo-0.0.1-SNAPSHOT.jar
COPY src/main/resources/application.properties .
EXPOSE 8081
ENTRYPOINT ["java","-Dspring.config.location=application.properties","-jar","todo-0.0.1-SNAPSHOT.jar"]
