#!/usr/bin/env bash

DOCKER_TAG=$1
DOCKERFILE_PATH=Dockerfile
IMAGE_NAME=locotestsoftware
DOCKER_REPO=blackforestsolutions
targetImage=$DOCKER_REPO/$IMAGE_NAME
targetImageTagged=$targetImage:$DOCKER_TAG

echo "docker tag is $DOCKER_TAG"

docker login

docker build --build-arg DOCKER_TAG=$DOCKER_TAG -f $DOCKERFILE_PATH -t $IMAGE_NAME .

sourceId=$(docker images --filter=reference=IMAGE_NAME --format "{{.ID}}")

docker tag $sourceId $targetImageTagged

docker push $targetImageTagged
