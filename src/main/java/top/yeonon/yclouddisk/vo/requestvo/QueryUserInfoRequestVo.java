package top.yeonon.yclouddisk.vo.requestvo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 23:09
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryUserInfoRequestVo {

    private Long id;

    public boolean validate() {
        return id != null && id > 0;
    }

}
