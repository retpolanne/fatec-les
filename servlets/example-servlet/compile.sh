#!/bin/sh

classpath=".:$(pwd)/servlet-api.jar"
javac -d ExampleServlet/WEB-INF/classes -target 8 -source 8 -classpath $classpath ExampleServlet/WEB-INF/src/example/*.java