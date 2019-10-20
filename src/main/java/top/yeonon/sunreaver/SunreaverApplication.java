package top.yeonon.sunreaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.yeonon.sunreaver.security.auth.AuthInterceptor;

@SpringBootApplication
public class SunreaverApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SunreaverApplication.class, args);
    }

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }
}
