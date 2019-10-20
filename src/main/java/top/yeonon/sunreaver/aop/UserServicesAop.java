package top.yeonon.sunreaver.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import top.yeonon.sunreaver.common.exception.SunreaverException;
import top.yeonon.sunreaver.common.response.ResponseStatus;
import top.yeonon.sunreaver.vo.RequestVo;

/**
 * @Author yeonon
 * @date 2019/10/16 0016 22:19
 **/
@Aspect
@Component
public class UserServicesAop {


    @Pointcut("@annotation(ParamValidate)")
    public void validateParam() {

    }

    @Before("validateParam()")
    public void doBefore(JoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof RequestVo) {
                RequestVo requestVo = (RequestVo)arg;
                if (!requestVo.validate()) {
                    throw new SunreaverException(ResponseStatus.REQUEST_PARAM_ERROR.getCode(),
                            ResponseStatus.REQUEST_PARAM_ERROR.getDescription());
                }
            }
        }
    }
}
