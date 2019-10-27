package top.yeonon.sunreaver.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.yeonon.sunreaver.userservice.auth.AuthInterceptor;

@SpringBootApplication
@RefreshScope
@ComponentScan(basePackages = "top.yeonon.sunreaver")
@EnableDiscoveryClient
public class SunreaverUserServiceApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SunreaverUserServiceApplication.class, args);
    }

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }
}
