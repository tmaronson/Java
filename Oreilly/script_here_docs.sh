#!/bin/bash
name=pidscript
touch $names.sh
chmod +x $name.sh
cat << EOF > $name.sh
#!/bin/bash
printf "%d %d\n" $PPID $$
EOF
bash $name.sh
