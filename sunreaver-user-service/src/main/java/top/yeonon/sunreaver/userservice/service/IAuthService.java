package top.yeonon.sunreaver.userservice.service;

import top.yeonon.sunreaver.common.exception.SunreaverException;
import top.yeonon.sunreaver.userservice.vo.requestvo.AcquireAuthTokenRequestVo;
import top.yeonon.sunreaver.userservice.vo.responsevo.AcquireAuthTokenResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 22:50
 **/
public interface IAuthService {

    /**
     * 获取authToken
     * @param requestVo 请求对象
     * @return 响应对象
     * @throws SunreaverException 可能抛出的异常
     */
    AcquireAuthTokenResponseVo acquireAuthToken(AcquireAuthTokenRequestVo requestVo)
            throws SunreaverException;

}
