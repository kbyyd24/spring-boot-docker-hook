package cn.gaoyuexiang.docker.demo.hook.dockerhook.webhook;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.time.ZonedDateTime.now;
import static java.time.ZoneId.of;

@RestController
public class HookController {

    private static Logger logger = LoggerFactory.getLogger(HookController.class);

    @PostMapping("/webhook/spring-boot-demo")
    public void updateImage() throws IOException {
        Process proc = new ProcessBuilder("updateImage.sh").start();
        if (proc.exitValue() == 0) {
            logger.info("Update image successed at {}.", now(of("Asia/Shanghai")).toString());
        } else {
            logger.error("Something wrong in updateing image at {}.", now(of("Asia/Shanghai")).toString());
        }
    }

}