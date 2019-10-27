package top.yeonon.sunreaver.userservice.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Author yeonon
 * @date 2019/10/13 0013 16:15
 **/
@Configuration
public class CacheConfig {

    @Bean
    public Cache<String, String> tokenCache() {
        //TODO: 暂时使用hard code，目前只是为了功能完整
        return Caffeine
                .newBuilder()
                .expireAfterWrite(60, TimeUnit.MINUTES)
                .expireAfterAccess(60, TimeUnit.MINUTES)
                .maximumSize(50000)
                .build();
    }
}
