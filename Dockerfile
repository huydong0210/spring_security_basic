FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY . /app

RUN mvn clean package

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/spring_security_basic-1.0-SNAPSHOT.jar app.jar

EXPOSE 80

CMD ["java", "-jar", "app.jar"]


