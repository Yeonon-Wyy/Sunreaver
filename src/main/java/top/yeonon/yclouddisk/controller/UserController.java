package top.yeonon.yclouddisk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.yeonon.yclouddisk.security.auth.TokenCheck;
import top.yeonon.yclouddisk.service.IUserService;
import top.yeonon.yclouddisk.vo.requestvo.QueryUserInfoRequestVo;
import top.yeonon.yclouddisk.vo.requestvo.UserRegistrationByPasswordRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.QueryUserInfoResponseVo;
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

    @PostMapping
    public UserRegistrationByPasswordResponseVo userRegistrationByPassword(@RequestBody UserRegistrationByPasswordRequestVo requestVo) {
        return userService.userRegistrationByPassword(requestVo);
    }

    @TokenCheck
    @GetMapping("/{id}")
    public QueryUserInfoResponseVo queryUserInfo(@PathVariable("id") Long id) {
        QueryUserInfoRequestVo requestVo = new QueryUserInfoRequestVo(id);
        return userService.queryUserInfo(requestVo);
    }

}
