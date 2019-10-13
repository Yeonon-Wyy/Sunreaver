package top.yeonon.yclouddisk.common.constant;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 23:08
 **/
public enum UserSex {
    MALE(1),
    FEMALE(2),
    FUZZY(3),
    ;

    private int code;

    UserSex(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
