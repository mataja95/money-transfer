FROM openjdk:11
LABEL maintainer="donnaagius1995@gmail.com"
VOLUME /tmp
EXPOSE 8080
ADD target/amount-transfer-rest-service-0.1.0.jar amount-transfer-rest-service-0.1.0.jar
ENTRYPOINT ["java","-jar","amount-transfer-rest-service-0.1.0.jar"]