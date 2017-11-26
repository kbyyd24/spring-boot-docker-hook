#should move this into PATH
container=spring_boot_demo

docker stop ${container}
docker rm ${container}
docker rmi yuexiang/spring-boot-demo
docker pull yuexiang/spring-boot-demo
docker run -d --name=${container} -p 80:8080 yuexiang/spring-boot-demo