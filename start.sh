#!/bin/bash

mvn compile
mvn package
#uncomment if you want to remove previous container
#docker-compose rm 
docker-compose build
docker-compose up