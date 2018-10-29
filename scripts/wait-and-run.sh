#!/bin/bash

echo "---------Waiting for mysql------------"
apt-get update && apt-get install mysql-client -y
until mysql -hmysql-docker-container -p3306 -uroot -proot
do
    echo -e "\n---------checking mysql---------"
    sleep 5
done

echo -e "\n---------mysql ready---------"
java -jar amount-transfer-rest-service-0.1.0.jar