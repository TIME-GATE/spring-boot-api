#!/bin/sh

tag="$(date +%Y%m%d%H%M%S)"
if [[ $1 ]]; then
	tag=$1
fi
image='dreamboat/spring-boot-api:'${tag}


docker build -t ${image} .

#docker push ${image}

echo ${image}
