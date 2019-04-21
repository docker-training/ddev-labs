#/bin/bash
set -e

docker push ${dockerID}/ddev_ui
docker push ${dockerID}/ddev_api
docker push ${dockerID}/ddev_db
