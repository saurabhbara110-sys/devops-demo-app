FROM eclipse-temurin:17-jre

WORKDIR /app

COPY src/Hello.class .

CMD ["java", "Hello"]
