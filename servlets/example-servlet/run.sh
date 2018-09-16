#!/bin/sh

docker run -p 8080:8080 -v "$PWD"/ExampleServlet:/usr/local/tomcat/webapps/exampleservlet --rm --name tomcat tomcat:alpine