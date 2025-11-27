# ====== Build stage ======
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copy Maven config and download dependencies
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# Copy source code and build jar
COPY src ./src
RUN mvn -q -DskipTests package

# ====== Run stage ======
FROM eclipse-temurin:21-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
