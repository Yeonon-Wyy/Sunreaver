package top.yeonon.yclouddisk.vo.requestvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 22:51
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcquireAuthTokenRequestVo {

    String username;
    String password;

    public boolean validate() {
        return StringUtils.isNotEmpty(username)
                && StringUtils.isNotEmpty(password);
    }

}
