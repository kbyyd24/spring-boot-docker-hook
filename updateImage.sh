container=spring_boot_demo

docker stop ${container}
docker rm ${container}
docker rmi yuexiang/spring-boot-demo
docker pull yuexiang/spring-boot-demo
docker run -d --name=${container} --network=host yuexiang/spring-boot-demo