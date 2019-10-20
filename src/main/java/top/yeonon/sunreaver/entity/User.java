package top.yeonon.sunreaver.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import top.yeonon.sunreaver.common.constant.DefaultAvatar;
import top.yeonon.sunreaver.common.constant.UserRole;
import top.yeonon.sunreaver.common.constant.UserStatus;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author yeonon
 * @date 2019/10/10 0010 22:31
 **/
@Entity
@Table(name = "sunreaver_user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false, length = 20)
    private String username;

    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "sex", nullable = false, length = 2)
    private Integer sex;

    @Column(name = "avatar", nullable = false, length = 128)
    private String avatar;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "email", length = 128, nullable = false)
    private String email;

    @Column(name = "profile", nullable = false)
    private String profile;

    @Column(name = "status", nullable = false, length = 4)
    private Integer status;

    @Column(name = "role", nullable = false, length = 4)
    private Integer role;

    @Column(name = "nick_name", nullable = false, length = 255)
    private String nickName;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "update_time", nullable = false)
    private Date updateTime;


    public User(String username, String password, Integer sex) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.avatar = DefaultAvatar.getAddress(sex);
        this.phoneNumber = StringUtils.EMPTY;
        this.profile = StringUtils.EMPTY;
        this.question = StringUtils.EMPTY;
        this.answer = StringUtils.EMPTY;
        this.email = StringUtils.EMPTY;
        this.status = UserStatus.NORMAL.getCode();
        this.role = UserRole.GENERAL.getCoed();
        this.nickName = RandomStringUtils.randomAlphabetic(15);
        this.createTime = new Date();
        this.updateTime = this.createTime;
    }

}
