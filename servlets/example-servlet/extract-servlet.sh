#!/bin/bash

docker exec -it tomcat cp lib/servlet-api.jar webapps/exampleservlet/
mv ExampleServlet/servlet-api.jar .