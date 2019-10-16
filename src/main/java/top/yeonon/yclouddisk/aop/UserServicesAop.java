package top.yeonon.yclouddisk.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import top.yeonon.yclouddisk.common.exception.YCDException;
import top.yeonon.yclouddisk.common.response.ResponseStatus;
import top.yeonon.yclouddisk.vo.RequestVo;

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
        System.out.println("参数校验");
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof RequestVo) {
                RequestVo requestVo = (RequestVo)arg;
                if (!requestVo.validate()) {
                    throw new YCDException(ResponseStatus.REQUEST_PARAM_ERROR.getCode(),
                            ResponseStatus.REQUEST_PARAM_ERROR.getDescription());
                }
            }
        }
    }
}
