FROM maven:3.9.9-amazoncorretto-21 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM amazoncorretto:21

WORKDIR /app

COPY --from=build /app/target/*.jar ./app.jar

ARG HOST_RABBITMQ=rabbitmq-host
ARG EUREKA_SERVER=localhost

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=development", "app.jar"]