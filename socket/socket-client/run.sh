#!/bin/sh
classpath=".:$(pwd)/src/jars/iohelper.jar"
cd src && java -classpath $classpath view.Main $1 $2