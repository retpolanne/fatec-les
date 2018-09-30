#!/bin/bash
docker exec -it exercicio3_tomcat_1 apk add mysql-client
docker exec -it exercicio3_tomcat_1 /tmp/recover-sql.sh