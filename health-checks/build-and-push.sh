docker image build -t ddev_db:1.0 database
docker image build -t ddev_api:1.0 api
docker image build -t ddev_ui:1.0 ui

docker image tag ddev_ui:1.0  ${dockerID}/ddev_ui:1.0
docker image tag ddev_api:1.0 ${dockerID}/ddev_api:1.0
docker image tag ddev_db:1.0  ${dockerID}/ddev_db:1.0

docker push ${dockerID}/ddev_ui:1.0
docker push ${dockerID}/ddev_api:1.0
docker push ${dockerID}/ddev_db:1.0
