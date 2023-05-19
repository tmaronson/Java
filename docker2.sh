#docker2.sh
docker build -t python-args . # tag build of Dockerfilepython
docker run -it python-args    # run app