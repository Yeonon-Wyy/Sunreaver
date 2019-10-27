package top.yeonon.sunreaver.common.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.yeonon.sunreaver.common.response.ServiceResponse;

/**
 * @Author yeonon
 * @date 2019/10/13 0013 13:33
 **/
@RestControllerAdvice
public class ControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        if (returnType.getDeclaringClass().isAnnotationPresent(IgnoreAdvice.class)) {
            return false;
        }
        if (returnType.getMethod().isAnnotationPresent(IgnoreAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (data == null) {
            return ServiceResponse.success();
        }
        if (data instanceof ServiceResponse) {
            return data;
        }
        return ServiceResponse.success(data);
    }
}
