#!/bin/sh
dir="iohelper"
PKGS=""

cd src && ls $dir | while read pkgs; do javac $dir/$pkgs/*.java; done
jar cvf iohelper.jar iohelper/contexts/*.class iohelper/interfaces/*.class iohelper/strategies/*.class