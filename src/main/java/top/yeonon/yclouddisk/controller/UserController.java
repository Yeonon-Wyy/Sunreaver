package top.yeonon.yclouddisk.controller;

import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yeonon.yclouddisk.service.IUserService;
import top.yeonon.yclouddisk.vo.requestvo.UserLoginByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.requestvo.UserRegistrationByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.UserLoginByPasswordResponseVo;
import top.yeonon.yclouddisk.vo.responsevo.UserRegistrationByPasswordResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 23:34
 **/
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private Cache<String, String> userIdCache;

    @PostMapping
    public UserRegistrationByPasswordResponseVo userRegistrationByPassword(@RequestBody UserRegistrationByPasswordRequestVo requestVo) {
        return userService.userRegistrationByPassword(requestVo);
    }

    @PostMapping("/login")
    public UserLoginByPasswordResponseVo userLoginByPassword(@RequestBody UserLoginByPasswordRequestVo requestVo) {
        return userService.userLoginByPassword(requestVo);
    }

}
