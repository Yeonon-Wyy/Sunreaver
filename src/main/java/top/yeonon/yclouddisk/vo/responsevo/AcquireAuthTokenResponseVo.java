package top.yeonon.yclouddisk.vo.responsevo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 22:52
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AcquireAuthTokenResponseVo {

    private Long userId;
    private String accessToken;

}
