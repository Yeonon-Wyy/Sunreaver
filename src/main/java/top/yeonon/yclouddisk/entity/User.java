package top.yeonon.yclouddisk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
