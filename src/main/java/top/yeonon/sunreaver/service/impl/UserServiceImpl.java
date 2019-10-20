package top.yeonon.sunreaver.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yeonon.sunreaver.aop.ParamValidate;
import top.yeonon.sunreaver.common.constant.UserStatus;
import top.yeonon.sunreaver.common.exception.SunreaverException;
import top.yeonon.sunreaver.common.response.ResponseStatus;
import top.yeonon.sunreaver.entity.User;
import top.yeonon.sunreaver.repository.UserRepository;
import top.yeonon.sunreaver.service.IUserService;
import top.yeonon.sunreaver.vo.requestvo.QueryUserInfoRequestVo;
import top.yeonon.sunreaver.vo.requestvo.UpdateUserInfoRequestVo;
import top.yeonon.sunreaver.vo.requestvo.UserRegistrationByPasswordRequestVo;
import top.yeonon.sunreaver.vo.responsevo.QueryUserInfoResponseVo;
import top.yeonon.sunreaver.vo.responsevo.UpdateUserInfoResponseVo;
import top.yeonon.sunreaver.vo.responsevo.UserRegistrationByPasswordResponseVo;

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
    public UserRegistrationByPasswordResponseVo userRegistrationByPassword(UserRegistrationByPasswordRequestVo userRequestVo) throws SunreaverException {
        //检查是否已存在用户名
        if (userRepository.existsByUsername(userRequestVo.getUsername())) {
            throw new SunreaverException(ResponseStatus.USERNAME_ALREADY_EXISTS.getCode(),
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
    public QueryUserInfoResponseVo queryUserInfo(QueryUserInfoRequestVo requestVo) throws SunreaverException {

        User user = userRepository.findById(requestVo.getId()).orElse(null);
        if (user == null || UserStatus.DELETE.getCode().equals(user.getStatus())) {
            throw new SunreaverException(ResponseStatus.NOT_EXIST_USER.getCode(),
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
    public QueryUserInfoResponseVo queryOtherUserInfo(QueryUserInfoRequestVo requestVo) throws SunreaverException {

        User user = userRepository.findById(requestVo.getId()).orElse(null);
        if (user == null || UserStatus.DELETE.getCode().equals(user.getStatus())) {
            throw new SunreaverException(ResponseStatus.NOT_EXIST_USER.getCode(),
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
    public UpdateUserInfoResponseVo updateUserInfo(UpdateUserInfoRequestVo requestVo) throws SunreaverException {

        User user = userRepository.findById(requestVo.getId()).orElse(null);
        if (user == null || UserStatus.DELETE.getCode().equals(user.getStatus())) {
            throw new SunreaverException(ResponseStatus.NOT_EXIST_USER.getCode(),
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
