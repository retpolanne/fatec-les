#!/bin/sh
cd src && nmap -sP 172.16.168.1/24 \
| grep -oE '\d+\.\d+\.\d+\.\d+' \
| while read ip; do java view.Socket $ip 1110; done