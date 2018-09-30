#!/bin/bash
docker exec -it exercicio2_tomcat_1 apk add mysql-client
docker exec -it exercicio2_tomcat_1 /tmp/recover-sql.sh