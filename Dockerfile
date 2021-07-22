FROM maven:3-openjdk-11 as MAVEN_BUILD
WORKDIR /build
COPY pom.xml .
RUN mvn clean dependency:go-offline
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/lottery*.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]
