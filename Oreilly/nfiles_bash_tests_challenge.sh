#!/bin/bash
i=1
while true
do
  touch $i.txt
  i=$(( i + 1 ))
  if [ $i -gt 50 ]; then
    break
  fi
done