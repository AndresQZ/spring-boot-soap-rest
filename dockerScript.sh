#!/bin/bash
#v.1.0
set -e

dockerignore() {
  echo ".git"                       > .dockerignore
  echo "tests"                     >> .dockerignore
}

dockerignore
mvn package dockerfile:build
docker run --name springRestSoap -d -p 8080:8080 --rm andresqz/spring-boot-soap-rest:1.0
