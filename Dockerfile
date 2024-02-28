FROM openjdk:17-slim as build

COPY target/spring.starter-0.0.1-SNAPSHOT.jar spring.starter-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "spring.starter-0.0.1-SNAPSHOT.jar"]