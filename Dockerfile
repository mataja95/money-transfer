FROM openjdk:11
LABEL maintainer="donnaagius1995@gmail.com"
VOLUME /tmp
EXPOSE 8080
ADD target/amount-transfer-rest-service-0.1.0.jar amount-transfer-rest-service-0.1.0.jar
ADD scripts/wait-and-run.sh wait-and-run.sh
ENTRYPOINT ["bash", "wait-and-run.sh"]
