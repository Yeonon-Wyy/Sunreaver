package top.yeonon.yclouddisk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yeonon.yclouddisk.service.IAuthService;
import top.yeonon.yclouddisk.vo.requestvo.AcquireAuthTokenRequestVo;
import top.yeonon.yclouddisk.vo.responsevo.AcquireAuthTokenResponseVo;

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
