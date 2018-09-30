#!/bin/sh
javac -d Usuario/WEB-INF/classes -target 8 -source 8 -classpath $CLASSPATH Usuario/WEB-INF/src/*/*.java