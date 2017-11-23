package cn.gaoyuexiang.docker.demo.hook.dockerhook.webhook;

import java.io.IOException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HookController {

    @PostMapping("/webhook/spring-boot-demo")
    public void updateImage() throws IOException {
        Runtime.getRuntime().exec("docker stop spring-boot-demo");
        Runtime.getRuntime().exec("docker rmi yuexiang/spring-boot-demo");
        Runtime.getRuntime().exec("docker pull yuexiang/spring-boot-demo");
        Runtime.getRuntime().exec("docker run -d --name spring-boot-demo --network=host yuexiang/spring-boot-demo");
    }
    
}