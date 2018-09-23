#!/bin/sh
javac -d CheckLogin/WEB-INF/classes -target 8 -source 8 -classpath $CLASSPATH CheckLogin/WEB-INF/src/*/*.java