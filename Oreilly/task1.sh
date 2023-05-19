#!/bin/bash
# This is correct but won't pass for some reason.
for f in $(
  find /root/task1/* -type f
  )
do
  echo $(basename -a "$f") is in the folder $(dirname "$f") >> /root/task1/output
done
  