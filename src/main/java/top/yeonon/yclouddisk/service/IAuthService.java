package top.yeonon.yclouddisk.service;

import top.yeonon.yclouddisk.common.exception.YCDException;
import top.yeonon.yclouddisk.vo.requestvo.AcquireAuthTokenRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.AcquireAuthTokenResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 22:50
 **/
public interface IAuthService {

    /**
     * 获取authToken
     * @param requestVo 请求对象
     * @return 响应对象
     * @throws YCDException 可能抛出的异常
     */
    AcquireAuthTokenResponseVo acquireAuthToken(AcquireAuthTokenRequestVo requestVo)
            throws YCDException;

}
