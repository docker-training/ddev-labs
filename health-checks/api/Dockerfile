FROM maven:3.5-jdk-8 AS build
COPY pom.xml .
RUN mvn --batch-mode dependency:resolve
COPY . .
RUN mvn --batch-mode package
RUN cp target/*jar target/app.jar

FROM openjdk:8-jre
EXPOSE 8080
VOLUME /tmp
COPY --from=build target/app.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


FROM maven:latest AS appserver
# we need curl for the healthcheck
RUN apt-get update -y && apt-get install -y curl
WORKDIR /usr/src/ddev
COPY pom.xml .
RUN mvn -B -f pom.xml -s /usr/share/maven/ref/settings-docker.xml dependency:resolve
COPY . .
RUN mvn -B -s /usr/share/maven/ref/settings-docker.xml package -DskipTests
