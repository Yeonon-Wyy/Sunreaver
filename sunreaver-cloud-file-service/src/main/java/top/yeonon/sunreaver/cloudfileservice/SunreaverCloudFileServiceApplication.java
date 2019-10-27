package top.yeonon.sunreaver.cloudfileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: yeonon
 * @date: 2019/10/27
 */
@SpringBootApplication
@ComponentScan(basePackages = "top.yeonon.sunreaver")
public class SunreaverCloudFileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SunreaverCloudFileServiceApplication.class, args);
    }
}
