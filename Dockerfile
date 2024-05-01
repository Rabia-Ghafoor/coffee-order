FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/coffee-order-0.0.1-SNAPSHOT.jar hw9part3.jar
ENTRYPOINT ["java", "-jar", "hw9part3.jar"]