FROM eclipse-temurin:21-jre

WORKDIR /app

COPY src/Hello.class .

CMD ["java", "Hello"]
