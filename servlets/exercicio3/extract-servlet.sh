#!/bin/bash

docker exec -it exercicio_tomcat_1 cp lib/servlet-api.jar webapps/CheckLogin/
mv CheckLogin/servlet-api.jar .