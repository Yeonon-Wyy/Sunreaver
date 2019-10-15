package top.yeonon.yclouddisk.service.impl;

import com.github.benmanes.caffeine.cache.Cache;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.map.SingletonMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yeonon.yclouddisk.common.exception.YCDException;
import top.yeonon.yclouddisk.common.response.ResponseStatus;
import top.yeonon.yclouddisk.common.util.JwtUtil;
import top.yeonon.yclouddisk.entity.User;
import top.yeonon.yclouddisk.repository.UserRepository;
import top.yeonon.yclouddisk.service.IAuthService;
import top.yeonon.yclouddisk.vo.requestvo.AcquireAuthTokenRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.AcquireAuthTokenResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 22:54
 **/
@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Cache<String, String> tokenCache;

    @Override
    public AcquireAuthTokenResponseVo acquireAuthToken(AcquireAuthTokenRequestVo requestVo) throws YCDException {
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

        return new AcquireAuthTokenResponseVo(
                user.getId(),
                token
        );


    }
}
