package cn.gaoyuexiang.docker.demo.hook.dockerhook.webhook;

import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
public class HookController {

    @PostMapping("/webhook/spring-boot-demo")
    public void updateImage() throws IOException {
        String container = "spring_boot_demo";
        String image = "yuexiang/spring-boot-demo";

        Runtime.getRuntime().exec(format("docker stop %s", container));
        Runtime.getRuntime().exec(format("docker rm %s", container));
        Runtime.getRuntime().exec(format("docker rmi %s", image));
        Runtime.getRuntime().exec(format("docker pull %s", image));
        Runtime.getRuntime().exec(format("docker run -d --name=%s --network=host %s", container, image));
    }

}