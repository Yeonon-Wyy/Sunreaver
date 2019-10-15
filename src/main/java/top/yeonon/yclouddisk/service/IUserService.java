package top.yeonon.yclouddisk.service;

import top.yeonon.yclouddisk.common.exception.YCDException;
import top.yeonon.yclouddisk.vo.requestvo.UserLoginByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.requestvo.UserRegistrationByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.UserLoginByPasswordResponseVo;
import top.yeonon.yclouddisk.vo.responsevo.UserRegistrationByPasswordResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/10 0010 22:51
 **/
public interface IUserService {

    /**
     * 用户注册(通过 用户名+密码的方式)
     * @param userRequestVo 用户注册Vo对象
     * @return 用户注册响应Vo对象
     * @throws YCDException 自定义业务异常
     */
    UserRegistrationByPasswordResponseVo userRegistrationByPassword(UserRegistrationByPasswordRequestVo userRequestVo)
            throws YCDException;


    UserLoginByPasswordResponseVo userLoginByPassword(UserLoginByPasswordRequestVo requestVo)
        throws YCDException;
}
