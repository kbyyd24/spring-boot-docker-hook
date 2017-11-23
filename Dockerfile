FROM java
MAINTAINER Yuexiang Gao

ADD build/libs/spring-docker-hook.jar app.jar
EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]