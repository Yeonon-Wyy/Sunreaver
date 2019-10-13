package top.yeonon.yclouddisk.vo.requestvo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author yeonon
 * @date 2019/10/13 0013 14:28
 **/
@Data
public class UserLoginByPasswordRequestVo {

    private String username;
    private String password;

    public boolean validate() {
        return StringUtils.isNotEmpty(username)
                && StringUtils.isNotEmpty(password);
    }
}
