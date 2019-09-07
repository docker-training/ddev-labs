docker image build -t ddev_db:1.2 database
docker image build -t ddev_api:1.2 api
docker image build -t ddev_ui:1.2 ui

docker image tag ddev_ui:1.2  ${dockerID}/ddev_ui:1.2
docker image tag ddev_api:1.2 ${dockerID}/ddev_api:1.2
docker image tag ddev_db:1.2  ${dockerID}/ddev_db:1.2

docker push ${dockerID}/ddev_ui:1.2
docker push ${dockerID}/ddev_api:1.2
docker push ${dockerID}/ddev_db:1.2
