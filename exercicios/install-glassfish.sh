#!/bin/bash
mkdir -p ~/.glassfish
wget -O ~/.glassfish/glassfish.zip http://download.oracle.com/glassfish/4.1.1/nightly/latest-glassfish.zip
unzip ~/.glassfish/glassfish.zip -d ~/.glassfish
echo "export CLASSPATH=.:$HOME/.glassfish/glassfish4/glassfish/modules/" >> ~/.zshrc

[ -z "$CLASSPATH" ] && echo "export CLASSPATH=.:$HOME/.glassfish/glassfish4/glassfish/modules/javax.servlet-api.jar" >> ~/.zshrc
[ -n "$CLASSPATH" ] && echo "export CLASSPATH=.:$HOME/.glassfish/glassfish4/glassfish/modules/javax.servlet-api.jar:$CLASSPATH" >> ~/.zshrc

echo "Done, please run source ~/.zshrc"