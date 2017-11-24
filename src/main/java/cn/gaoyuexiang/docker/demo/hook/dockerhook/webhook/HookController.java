package cn.gaoyuexiang.docker.demo.hook.dockerhook.webhook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
public class HookController {

    @PostMapping("/webhook/spring-boot-demo")
    public void updateImage() throws IOException {
        String container = "spring_boot_demo";
        String image = "yuexiang/spring-boot-demo";

        Process proc = Runtime.getRuntime().exec(format(
                "docker stop %s && docker rm %s && docker rmi %s && docker pull %s && docker run -d --name=%s --network=host %s",
                container, container, image, image, container, image));
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String s = null;
        while((s = reader.readLine())!=null) {
            System.out.println(s);
        }
    }

}