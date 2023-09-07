FROM maven:3.9.4-eclipse-temurin-17-alpine as stage1
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY ./src ./src
RUN mvn clean install -Dmaven.test.skip=true
FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY --from=stage1 /app/target/app.jar /app
ENTRYPOINT ["java","-jar","/app/app.jar"]