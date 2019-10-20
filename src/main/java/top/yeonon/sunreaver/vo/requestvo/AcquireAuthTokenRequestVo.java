package top.yeonon.sunreaver.vo.requestvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import top.yeonon.sunreaver.vo.RequestVo;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 22:51
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcquireAuthTokenRequestVo implements RequestVo {

    String username;
    String password;

    @Override
    public boolean validate() {
        return StringUtils.isNotEmpty(username)
                && StringUtils.isNotEmpty(password);
    }

}
