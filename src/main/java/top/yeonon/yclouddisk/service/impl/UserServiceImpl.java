package top.yeonon.yclouddisk.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yeonon.yclouddisk.aop.ParamValidate;
import top.yeonon.yclouddisk.common.constant.UserStatus;
import top.yeonon.yclouddisk.common.exception.YCDException;
import top.yeonon.yclouddisk.common.response.ResponseStatus;
import top.yeonon.yclouddisk.entity.User;
import top.yeonon.yclouddisk.repository.UserRepository;
import top.yeonon.yclouddisk.service.IUserService;
import top.yeonon.yclouddisk.vo.requestvo.QueryUserInfoRequestVo;
import top.yeonon.yclouddisk.vo.requestvo.UpdateUserInfoRequestVo;
import top.yeonon.yclouddisk.vo.requestvo.UserRegistrationByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.QueryUserInfoResponseVo;
import top.yeonon.yclouddisk.vo.responsevo.UpdateUserInfoResponseVo;
import top.yeonon.yclouddisk.vo.responsevo.UserRegistrationByPasswordResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 23:33
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @ParamValidate
    @Override
    public UserRegistrationByPasswordResponseVo userRegistrationByPassword(UserRegistrationByPasswordRequestVo userRequestVo) throws YCDException {
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

    @ParamValidate
    @Override
    public QueryUserInfoResponseVo queryUserInfo(QueryUserInfoRequestVo requestVo) throws YCDException {

        User user = userRepository.findById(requestVo.getId()).orElse(null);
        if (user == null || UserStatus.DELETE.getCode().equals(user.getStatus())) {
            throw new YCDException(ResponseStatus.NOT_EXIST_USER.getCode(),
                    ResponseStatus.NOT_EXIST_USER.getDescription());
        }

        return new QueryUserInfoResponseVo(
                user.getNickName(),
                user.getSex(),
                user.getAvatar(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getProfile(),
                user.getStatus(),
                user.getRole(),
                user.getCreateTime(),
                user.getUpdateTime()
        );
    }

    @ParamValidate
    @Override
    public QueryUserInfoResponseVo queryOtherUserInfo(QueryUserInfoRequestVo requestVo) throws YCDException {

        User user = userRepository.findById(requestVo.getId()).orElse(null);
        if (user == null || UserStatus.DELETE.getCode().equals(user.getStatus())) {
            throw new YCDException(ResponseStatus.NOT_EXIST_USER.getCode(),
                    ResponseStatus.NOT_EXIST_USER.getDescription());
        }

        return new QueryUserInfoResponseVo(
                user.getNickName(),
                user.getSex(),
                user.getAvatar(),
                user.getProfile(),
                user.getRole()
        );
    }

    @Override
    public UpdateUserInfoResponseVo updateUserInfo(UpdateUserInfoRequestVo requestVo) throws YCDException {

        User user = userRepository.findById(requestVo.getId()).orElse(null);
        if (user == null || UserStatus.DELETE.getCode().equals(user.getStatus())) {
            throw new YCDException(ResponseStatus.NOT_EXIST_USER.getCode(),
                    ResponseStatus.NOT_EXIST_USER.getDescription());
        }

        //更新user info，不用flush
        //JPA 不能只更新非null值，所以需要手动判断
        user = userRepository.save(requestVo.updateUser(user));
        return new UpdateUserInfoResponseVo(
                user.getId()
        );

    }
}
