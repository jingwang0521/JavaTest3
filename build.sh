#!/bin/bash

echo "开始运行"
mvn clean package

cd docker/java
docker build -t exam1 .

cd ..
cd mysql
docker build -t mysql .






