#!/bin/sh
javac -d ExampleServlet/WEB-INF/classes -target 8 -source 8 -classpath $CLASSPATH ExampleServlet/WEB-INF/src/example/*.java