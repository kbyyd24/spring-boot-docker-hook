package cn.gaoyuexiang.docker.demo.hook.dockerhook.webhook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HookController {

    @PostMapping("/webhook/spring-boot-demo")
    public void updateImage() throws IOException {
        Process proc = Runtime.getRuntime().exec("pwd");
        BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String s = null;
        while((s = reader.readLine())!=null) {
            System.out.println(s);
        }
    }
    
}