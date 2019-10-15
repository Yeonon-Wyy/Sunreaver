package top.yeonon.yclouddisk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.yeonon.yclouddisk.security.auth.AuthInterceptor;

@SpringBootApplication
public class YCloudDiskApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(YCloudDiskApplication.class, args);
    }

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }
}
