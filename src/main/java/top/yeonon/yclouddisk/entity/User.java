package top.yeonon.yclouddisk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.yeonon.yclouddisk.common.constant.DefaultAvatar;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author yeonon
 * @date 2019/10/10 0010 22:31
 **/
@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 11)
    private String username;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "sex", nullable = false, length = 2)
    private Integer sex;

    @Column(name = "avatar", nullable = false, length = 128)
    private String avatar;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "profile")
    private String profile;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "update_time", nullable = false)
    private Date updateTime;

    public User(String username, String password, Integer sex) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.avatar = DefaultAvatar.getAddress(sex);
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }

}
