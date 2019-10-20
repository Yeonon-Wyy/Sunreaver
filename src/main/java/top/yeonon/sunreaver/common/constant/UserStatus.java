package top.yeonon.sunreaver.common.constant;

import lombok.Getter;

/**
 * @Author yeonon
 * @date 2019/10/15 0015 23:18
 **/
@Getter
public enum UserStatus {

    // code less 0 is bad state, grater or equal 0 is good state

    // good state
    NORMAL(0, "Normal"),

    // bad state
    RESTRICTED(-1, "Restricted Action"),
    DELETE(-2, "User Deleted")
    ;


    private Integer code;
    private String description;

    UserStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }
}
