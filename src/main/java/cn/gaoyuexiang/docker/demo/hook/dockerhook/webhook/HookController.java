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
        new ProcessBuilder("updateImage.sh").start();
    }

}