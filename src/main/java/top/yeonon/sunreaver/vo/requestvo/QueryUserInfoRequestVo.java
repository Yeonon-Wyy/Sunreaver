package top.yeonon.sunreaver.vo.requestvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import top.yeonon.sunreaver.vo.RequestVo;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 23:09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryUserInfoRequestVo implements RequestVo {

    private Long id;

    @Override
    public boolean validate() {
        return id != null && id >= 0;
    }

}
