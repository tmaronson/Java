# task 1 Bash loops and arguments

#!/bin/bash
name=100files
mkdir $name
cd $name
touch {0..99}.txt

#task 2 Bash loops and arguments

#!/bin/bash
name=nfiles
mkdir $name
cd $name
touch {0..$1}.txt