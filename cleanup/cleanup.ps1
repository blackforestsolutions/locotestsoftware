#cleanup the complete set up

docker stop $(docker ps -a -q)
echo "All docker containers running were stopped"

docker rmi $(docker images -a -q)
echo "all containers were deleted"