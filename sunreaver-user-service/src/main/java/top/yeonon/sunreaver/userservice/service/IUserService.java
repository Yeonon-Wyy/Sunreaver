package top.yeonon.sunreaver.userservice.service;

import top.yeonon.sunreaver.common.exception.SunreaverException;
import top.yeonon.sunreaver.userservice.vo.requestvo.QueryUserInfoRequestVo;
import top.yeonon.sunreaver.userservice.vo.requestvo.UpdateUserInfoRequestVo;
import top.yeonon.sunreaver.userservice.vo.requestvo.UserRegistrationByPasswordRequestVo;
import top.yeonon.sunreaver.userservice.vo.responsevo.QueryUserInfoResponseVo;
import top.yeonon.sunreaver.userservice.vo.responsevo.UpdateUserInfoResponseVo;
import top.yeonon.sunreaver.userservice.vo.responsevo.UserRegistrationByPasswordResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/10 0010 22:51
 **/
public interface IUserService {

    /**
     * 用户注册(通过 用户名+密码的方式)
     * @param userRequestVo 用户注册Vo对象
     * @return 用户注册响应Vo对象
     * @throws SunreaverException 自定义业务异常
     */
    UserRegistrationByPasswordResponseVo userRegistrationByPassword(UserRegistrationByPasswordRequestVo userRequestVo)
            throws SunreaverException;


    /**
     * 查询用户信息（本人查看）
     * @param requestVo 请求对象
     * @return 响应对象
     * @throws SunreaverException 抛出的异常
     */
    QueryUserInfoResponseVo queryUserInfo(QueryUserInfoRequestVo requestVo)
            throws SunreaverException;

    /**
     * 查询其他用户信息
     * @param requestVo 请求对象
     * @return 响应对象
     * @throws SunreaverException 抛出的异常
     */
    QueryUserInfoResponseVo queryOtherUserInfo(QueryUserInfoRequestVo requestVo)
            throws SunreaverException;


    /**
     * 更新用户信息
     * @param requestVo 请求对象
     * @return 响应对象
     * @throws SunreaverException 抛出的异常
     */
    UpdateUserInfoResponseVo updateUserInfo(UpdateUserInfoRequestVo requestVo)
            throws SunreaverException;


}
