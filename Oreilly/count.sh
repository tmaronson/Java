#!/bin/bash
# This is "Waiting for Tasks to Complete"
find * -type d | wc -l | xargs -n1 printf "%d"
find * -type f | wc -l | xargs -n1 printf " %d"
num_lines=0 # total number of lines in files
tot_secret_count=0 # total files with phrase 'secret'
for f in $(
    find /root/files -type f 
    )
do
     file_lines="$(wc -l "$f" | cut -f1 -d' ')"
    num_lines=$(( num_lines + file_lines ))
    secret_count="$(grep -c 'secret' "$f")"
    if [ "$secret_count" -gt 0 ]; then
      tot_secret_count=$(( tot_secret_count + 1 ))
    fi
done
echo $num_lines | xargs -n1 printf " %d"
echo $tot_secret_count | xargs -n1 printf " %d\n"