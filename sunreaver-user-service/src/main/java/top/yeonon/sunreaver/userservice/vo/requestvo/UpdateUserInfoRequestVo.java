package top.yeonon.sunreaver.userservice.vo.requestvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import top.yeonon.sunreaver.userservice.entity.User;
import top.yeonon.sunreaver.userservice.vo.RequestVo;

/**
 * @Author yeonon
 * @date 2019/10/16 0016 22:45
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserInfoRequestVo implements RequestVo {

    private Long id;
    private Integer sex;
    private String profile;

    @Override
    public boolean validate() {
        return id != null && id >= 0;
    }


    public User updateUser(User user) {
        if (sex != null && sex >= 0) {
            user.setSex(sex);
        }
        if (StringUtils.isNotEmpty(profile)) {
            user.setProfile(profile);
        }
        return user;
    }
}
