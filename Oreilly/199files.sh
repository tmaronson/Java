
#! /bin/bash
cd /root/100files
i=0
while [ $i -lt 100 ]
do
    touch $i.txt
    (( i = $i + 1 )) 
done