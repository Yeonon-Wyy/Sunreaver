package top.yeonon.sunreaver.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.yeonon.sunreaver.userservice.service.IAuthService;
import top.yeonon.sunreaver.userservice.vo.requestvo.AcquireAuthTokenRequestVo;
import top.yeonon.sunreaver.userservice.vo.responsevo.AcquireAuthTokenResponseVo;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 22:56
 **/
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping
    public AcquireAuthTokenResponseVo acquireAuthToken(@RequestBody AcquireAuthTokenRequestVo requestVo) {
        return authService.acquireAuthToken(requestVo);
    }

}
