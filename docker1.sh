#docker1.sh   
docker build -t java-app . # tag build of Dockerfile - this will be name of new image
docker run -it java-app    # run app