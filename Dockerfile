FROM eclipse-temurin:21-jre

WORKDIR /app

COPY src/Hello.class .

EXPOSE 8081

CMD ["java", "Hello"]
