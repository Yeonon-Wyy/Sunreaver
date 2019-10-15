package top.yeonon.yclouddisk.service.impl;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.map.SingletonMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yeonon.yclouddisk.common.exception.YCDException;
import top.yeonon.yclouddisk.common.response.ResponseStatus;
import top.yeonon.yclouddisk.common.response.ServiceResponse;
import top.yeonon.yclouddisk.common.util.JwtUtil;
import top.yeonon.yclouddisk.entity.User;
import top.yeonon.yclouddisk.repository.UserRepository;
import top.yeonon.yclouddisk.service.IUserService;
import top.yeonon.yclouddisk.vo.requestvo.UserLoginByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.requestvo.UserRegistrationByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.UserLoginByPasswordResponseVo;
import top.yeonon.yclouddisk.vo.responsevo.UserRegistrationByPasswordResponseVo;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 23:33
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private Cache<String, String> tokenCache;

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
    public UserLoginByPasswordResponseVo userLoginByPassword(UserLoginByPasswordRequestVo requestVo) throws YCDException {
        if (!requestVo.validate()) {
            throw new YCDException(ResponseStatus.REQUEST_PARAM_ERROR.getCode(),
                    ResponseStatus.REQUEST_PARAM_ERROR.getDescription());
        }

        //检查用户名和密码是否正确
        User user = userRepository.findUserByUsernameAndPassword(requestVo.getUsername(),
                DigestUtils.md5Hex(requestVo.getPassword()));
        if (user == null) {
            throw new YCDException(ResponseStatus.USERNAME_OR_PASSWORD_ERROR.getCode(),
                    ResponseStatus.USERNAME_OR_PASSWORD_ERROR.getDescription());
        }

        String token = JwtUtil.generateToken(new SingletonMap<>("id", user.getId()));
        //将用户token信息存入cache
        tokenCache.put(String.valueOf(user.getId()), token);

        return new UserLoginByPasswordResponseVo(
                user.getId()
        );
    }
}
