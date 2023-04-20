FROM mcr.microsoft.com/openjdk/jdk:17-mariner as build

WORKDIR /app
ADD src /app/src
ADD pom.xml /app/pom.xml
ADD mvnw /app/mvnw
ADD .mvn /app/.mvn
RUN ./mvnw package

FROM mcr.microsoft.com/openjdk/jdk:17-mariner as run
WORKDIR /app
COPY --from=build /app/target/demo-1.0-SNAPSHOT-jar-with-dependencies.jar /app.jar
USER app
CMD ["java", "-cp", "/app.jar", "com.example.App"]
