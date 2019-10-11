package top.yeonon.yclouddisk.service.impl;

import org.springframework.stereotype.Service;
import top.yeonon.yclouddisk.common.response.ServiceResponse;
import top.yeonon.yclouddisk.service.IUserService;
import top.yeonon.yclouddisk.vo.requestvo.UserRegistrationByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.UserRegistrationByPasswordResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 23:33
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public ServiceResponse<UserRegistrationByPasswordResponseVo> userRegistration(UserRegistrationByPasswordRequestVo userRequestVo) {
        return null;
    }
}
