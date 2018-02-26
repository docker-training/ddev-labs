docker image tag ddev_ui:latest  $MY_DOCKER_ID/ddev_ui:1.0
docker image tag ddev_api:latest $MY_DOCKER_ID/ddev_api:1.0
docker image tag ddev_db:latest  $MY_DOCKER_ID/ddev_db:1.0

docker push $MY_DOCKER_ID/ddev_ui:1.0
docker push $MY_DOCKER_ID/ddev_api:1.0
docker push $MY_DOCKER_ID/ddev_db:1.0