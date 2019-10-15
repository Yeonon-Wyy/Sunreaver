package top.yeonon.yclouddisk.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yeonon.yclouddisk.common.constant.UserStatus;
import top.yeonon.yclouddisk.common.exception.YCDException;
import top.yeonon.yclouddisk.common.response.ResponseStatus;
import top.yeonon.yclouddisk.entity.User;
import top.yeonon.yclouddisk.repository.UserRepository;
import top.yeonon.yclouddisk.service.IUserService;
import top.yeonon.yclouddisk.vo.requestvo.QueryUserInfoRequestVo;
import top.yeonon.yclouddisk.vo.requestvo.UserRegistrationByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.QueryUserInfoResponseVo;
import top.yeonon.yclouddisk.vo.responsevo.UserRegistrationByPasswordResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 23:33
 **/
@Service
public class UserServiceImpl implements IUserService {



    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRegistrationByPasswordResponseVo userRegistrationByPassword(UserRegistrationByPasswordRequestVo userRequestVo) throws YCDException {
        if (!userRequestVo.validate()) {
            throw new YCDException(ResponseStatus.REQUEST_PARAM_ERROR.getCode(),
                    ResponseStatus.REQUEST_PARAM_ERROR.getDescription());
        }
        //检查是否已存在用户名
        if (userRepository.existsByUsername(userRequestVo.getUsername())) {
            throw new YCDException(ResponseStatus.USERNAME_ALREADY_EXISTS.getCode(),
                    ResponseStatus.USERNAME_ALREADY_EXISTS.getDescription());
        }

        User user = new User(
                userRequestVo.getUsername(),
                DigestUtils.md5Hex(userRequestVo.getPassword()),
                userRequestVo.getSex()
        );

        //存入数据库
        user = userRepository.saveAndFlush(user);
        return new UserRegistrationByPasswordResponseVo(
                user.getId()
        );
    }

    @Override
    public QueryUserInfoResponseVo queryUserInfo(QueryUserInfoRequestVo requestVo) throws YCDException {
        if (!requestVo.validate()) {
            throw new YCDException(ResponseStatus.REQUEST_PARAM_ERROR.getCode(),
                    ResponseStatus.REQUEST_PARAM_ERROR.getDescription());
        }

        User user = userRepository.findById(requestVo.getId()).orElse(null);
        if (user == null || UserStatus.LOGOUT.getCode().equals(user.getStatus())) {
            throw new YCDException(ResponseStatus.NOT_EXIST_USER.getCode(),
                    ResponseStatus.NOT_EXIST_USER.getDescription());
        }

        return new QueryUserInfoResponseVo(
                user.getUsername(),
                user.getPassword(),
                user.getSex(),
                user.getAvatar(),
                user.getPhoneNumber(),
                user.getProfile(),
                user.getStatus(),
                user.getCreateTime(),
                user.getUpdateTime()
        );
    }
}
