#!/bin/bash
mkdir -p name
touch name/name.sh
chmod +x name/name.sh
cat << EOF > name/name.sh
#!/bin/bash
echo "Tom"
EOF
bash name/name.sh
rm -rf name/*
rmdir name
