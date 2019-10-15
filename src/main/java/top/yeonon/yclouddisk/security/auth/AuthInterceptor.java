package top.yeonon.yclouddisk.security.auth;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import top.yeonon.yclouddisk.common.exception.YCDException;
import top.yeonon.yclouddisk.common.response.ResponseStatus;
import top.yeonon.yclouddisk.common.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author yeonon
 * @date 2019/10/14 0014 22:31
 **/
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private Cache<String, String> tokenCache;

    private static final String AUTH_TOKEN = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //判断是否需要拦截
        if (!handlerMethod.hasMethodAnnotation(TokenCheck.class)) {
            return true;
        }

        //从Authorization 里取出token
        String tokenWithBaraer = request.getHeader(AUTH_TOKEN);
        if (tokenWithBaraer == null) {
            throw new YCDException(ResponseStatus.NOT_EXIST_TOKEN_IN_HEAD.getCode(),
                    ResponseStatus.NOT_EXIST_TOKEN_IN_HEAD.getDescription());
        }
        String token = tokenWithBaraer.substring(7);

        Long userId = JwtUtil.getValueFromToken(token, "id", Long.class);
        if (!token.equals(tokenCache.getIfPresent(String.valueOf(userId)))
            || !getUserId(request).equals(userId)) {
            throw new YCDException(ResponseStatus.NOT_ALLOW_ACTION.getCode(),
                    ResponseStatus.NOT_ALLOW_ACTION.getDescription());
        }

        return true;
    }

    private Long getUserId(HttpServletRequest request) {
        //HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE 这个常量是用于获取REST风格的路径参数，如{id}
        Map info = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        return Long.valueOf(String.valueOf(info.get("id")));
    }
}
