package top.yeonon.sunreaver.userservice.vo.responsevo;

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

    private String nickName;
    private Integer sex;
    private String avatar;
    private String email;
    private String phoneNumber;
    private String profile;
    private Integer status;
    private Integer role;
    private Date createTime;
    private Date updateTime;

    public QueryUserInfoResponseVo(String nickName, Integer sex, String avatar, String profile, Integer role) {
        this.nickName = nickName;
        this.sex = sex;
        this.avatar = avatar;
        this.profile = profile;
        this.role = role;
    }
}
