FROM openjdk:11

WORKDIR /app

COPY target/lottery*.jar /app/app.jar

CMD ["java", "-jar", "app.jar"]
