
#! /bin/bash
cd /root/nfiles
i=1
while [ $i -le $1 ]
do
    touch $i.txt
    (( i = $i + 1 )) 
done