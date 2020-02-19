FROM postgres:9.6

# Add some static config
COPY pg_hba.conf /usr/share/postgresql/9.6/
COPY postgresql.conf /usr/share/postgresql/9.6/
# Contents of /docker-entrypoint-initdb.d are run on startup
ADD  docker-entrypoint-initdb.d/ /docker-entrypoint-initdb.d/

# Default values for passwords and database name. Can be overridden on docker run
ENV POSTGRES_USER gordonuser
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB ddev
