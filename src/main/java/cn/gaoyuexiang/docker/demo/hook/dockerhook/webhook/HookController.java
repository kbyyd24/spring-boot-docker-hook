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

        Runtime.getRuntime().exec(format(
                "docker stop %s && docker rm %s && docker rmi %s && docker pull %s && docker run -d --name=%s --network=host %s",
                container, container, image, image, container, image));
    }

}