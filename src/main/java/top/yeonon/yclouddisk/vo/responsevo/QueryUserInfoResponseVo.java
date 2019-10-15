package top.yeonon.yclouddisk.vo.responsevo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 23:11
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QueryUserInfoResponseVo {

    private String username;
    private String password;
    private Integer sex;
    private String avatar;
    private String phoneNumber;
    private String profile;
    private Integer status;
    private Date createTime;
    private Date updateTime;

}
