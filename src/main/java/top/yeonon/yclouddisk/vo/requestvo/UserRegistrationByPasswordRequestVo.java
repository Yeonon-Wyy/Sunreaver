package top.yeonon.yclouddisk.vo.requestvo;


import lombok.*;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 23:02
 **/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegistrationByPasswordRequestVo {

    private String username;
    private String password;
    private Integer sex;

    public boolean validate() {
        return StringUtils.isNotEmpty(username)
                && StringUtils.isNotEmpty(password)
                && sex != null && sex >= 0;
    }
}
