#/bin/bash
set -e

docker push ${dockerID}/ddev_ui:1.0
docker push ${dockerID}/ddev_api:1.0
docker push ${dockerID}/ddev_db:1.0
