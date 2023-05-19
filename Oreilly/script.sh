#! /bin/bash
for dir in $(
  find /root/files -type d 
  )
do
  f1="$(find "$dir" -type f | head -1)"
  f2="$(find "$dir" -type f | tail -1)"
  diff "$f1" "$f2" >> /root/output.log
done

# did not pass but this is correct. O'Reilly looks for exact file structure match.