FROM maven:3.9.9-amazoncorretto-21 AS build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests

FROM amazoncorretto:21

WORKDIR /app

COPY --from=build /app/target/*.jar ./app.jar

ARG EUREKA_SERVER=localhost
ARG KEYCLOAK_SERVER=localhost
ARG KEYCLOAK_PORT=8081

ENTRYPOINT ["java", "-jar", "app.jar"]