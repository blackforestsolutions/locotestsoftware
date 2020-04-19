#Gather all parameter with the different tags
#Declare Docker repo name as Variable
$DOCKER_REPO='blackforestsolutions';

#declare all available repos to test
$tagLocoCrawler=$args[0];
$imageLocoCrawler="lococrawler";
$fullQualifiedImageLocoCrawler=$DOCKER_REPO + '/' + $imageLocoCrawler + ':' + $tagLocoCrawler;
echo "crawler full qualified docker image name is: $fullQualifiedImageLocoCrawler ";

$tagLocoApiService=$args[1];
$imageLocoApiService="locoapiservice";
$fullQualifiedImageLocoApiService=$DOCKER_REPO + '/' + $imageLocoApiService + ':' + $tagLocoApiService;
echo "api service full qualified docker image name is: $fullQualifiedImageLocoApiService ";

$tagLocoHazelcast=$args[2];
$imageLocoHazelcast="locohazelcast";
$fullQualifiedImageLocoHazelcast=$DOCKER_REPO + '/' + $imageLocoHazelcast + ':' + $tagLocoHazelcast;
echo "hazelcast full qualified docker image name is: $fullQualifiedImageLocoHazelcast ";

$tagLocoFrontendAng=$args[3];
$imageLocoFrontendAng="locofrontendAng";
$fullQualifiedImageLocoFrontendAng=$DOCKER_REPO + '/' + $imageLocoFrontendAng + ':' + $tagLocoFrontendAng;
echo "frontend full qualified docker image name is: $fullQualifiedImageLocoFrontendAng ";

docker login;

docker run -d -p 8082:82 $fullQualifiedImageLocoCrawler;

docker run -d -p 8083:83 $fullQualifiedImageLocoApiService;

docker run -d -p 8081:81 $fullQualifiedImageLocoHazelcast;

#docker run -d -p 8093:80 $fullQualifiedImageLocoFrontendAng;