#!/bin/sh

docker-compose -p exercicio up -d
./recover-sql-local.sh