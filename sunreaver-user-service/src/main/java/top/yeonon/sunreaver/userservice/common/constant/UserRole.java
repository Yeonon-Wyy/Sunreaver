package top.yeonon.sunreaver.userservice.common.constant;

import lombok.Getter;

/**
 * @Author yeonon
 * @date 2019/10/16 0016 21:18
 **/
@Getter
public enum UserRole {
    GENERAL(0, "General user"),
    VIP(1, "VIP"),
    SVIP(2, "Super VIP")
    ;

    private int coed;
    private String description;

    UserRole(int coed, String description) {
        this.coed = coed;
        this.description = description;
    }
}
