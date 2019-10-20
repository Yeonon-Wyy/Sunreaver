package top.yeonon.sunreaver.vo.requestvo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import top.yeonon.sunreaver.vo.RequestVo;

/**
 * @Author yeonon
 * @date 2019/10/13 0013 14:28
 **/
@Data
public class UserLoginByPasswordRequestVo implements RequestVo {

    private String username;
    private String password;

    @Override
    public boolean validate() {
        return StringUtils.isNotEmpty(username)
                && StringUtils.isNotEmpty(password);
    }
}
