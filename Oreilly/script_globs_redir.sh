#!/bin/bash
for f in $(
  # sort on filename on not entire path 
  basename -a `find /root/files -type f -name '???????' -a -name '*a*b*'` | sort 
  )
do
  bash `find . -name $f` 1>>/root/standard 2>>/root/error
done
