#! /bin/bash

./output.sh 1>stdout.log 2>stderr.log
#Add line below for task 3.
./output.sh > all.log 2>&1