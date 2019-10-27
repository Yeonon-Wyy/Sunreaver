package top.yeonon.sunreaver.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.yeonon.sunreaver.common.response.ResponseStatus;
import top.yeonon.sunreaver.common.response.ServiceResponse;

/**
 * @Author yeonon
 * @date 2019/10/12 0012 23:05
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SunreaverException.class)
    public ServiceResponse handleSunreaverException(SunreaverException e) {
        return ServiceResponse.error(ResponseStatus.ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ServiceResponse handleInternalException(Exception e) {
        return ServiceResponse.error(e.getMessage());
    }
}
