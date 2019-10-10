package top.yeonon.yclouddisk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.yeonon.yclouddisk.constant.ShareMode;
import top.yeonon.yclouddisk.entity.CloudFile;
import top.yeonon.yclouddisk.entity.User;
import top.yeonon.yclouddisk.repository.CloudFileRepository;
import top.yeonon.yclouddisk.repository.UserRepository;

import java.util.Date;

/**
 * @Author yeonon
 * @date 2019/10/9 0009 23:56
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CloudFileRepository cloudFileRepository;

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("/cloudFile")
    public CloudFile insertFile(CloudFile cloudFile) {
        cloudFile.setUpdateTime(new Date());
        cloudFile.setShareMode(ShareMode.ALLOW_SHARE_EVERYONE.getCode());
        return cloudFileRepository.saveAndFlush(cloudFile);
    }
}
