FROM tomcat:alpine

RUN wget https://cdn.mysql.com//Downloads/Connector-J/mysql-connector-java-8.0.12.zip -O /usr/local/tomcat/lib/mysql.zip
RUN unzip /usr/local/tomcat/lib/mysql.zip -p mysql-connector-java-8.0.12/mysql-connector-java-8.0.12.jar > /usr/local/tomcat/lib/mysql.jar \
&& rm /usr/local/tomcat/lib/mysql.zip