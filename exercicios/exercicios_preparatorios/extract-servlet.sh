#!/bin/bash

docker exec -it exercicio4_tomcat_1 cp lib/servlet-api.jar webapps/Jogos/
mv Jogos/servlet-api.jar .