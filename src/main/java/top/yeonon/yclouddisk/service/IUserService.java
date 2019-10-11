package top.yeonon.yclouddisk.service;

import top.yeonon.yclouddisk.common.response.ServiceResponse;
import top.yeonon.yclouddisk.entity.User;
import top.yeonon.yclouddisk.vo.requestvo.UserRegistrationByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.UserRegistrationByPasswordResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/10 0010 22:51
 **/
public interface IUserService {

    ServiceResponse<UserRegistrationByPasswordResponseVo> userRegistration(UserRegistrationByPasswordRequestVo userRequestVo);


}
