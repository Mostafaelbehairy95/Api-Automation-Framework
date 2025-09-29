FROM maven:3.9-eclipse-temurin-25

COPY src /apitesting/Restassured/src

COPY pom.xml /apitesting/Restassured/pom.xml

COPY testng.xml /apitesting/Restassured/testng.xml

WORKDIR /apitesting/Restassured

ENTRYPOINT mvn clean test