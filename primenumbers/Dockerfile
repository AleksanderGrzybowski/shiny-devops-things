FROM openjdk:8-jdk

COPY . /primenumbers
WORKDIR /primenumbers

RUN ./gradlew clean test bootRepackage

FROM openjdk:8-jre

COPY --from=0 /primenumbers/build/libs/primenumbers-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]
