package top.yeonon.sunreaver.common.constant;

/**
 * @Author yeonon
 * @date 2019/10/10 0010 23:11
 **/
public enum ShareMode {
    ALLOW_SHARE_EVERYONE(100, "can share to everyone"),
    NOT_ALLOW_SHARE_ANYONE(0, "can't share to anyone"),
    ALLOW_SHARE_SOMEONE(1, "can share to someone");

    private Integer code;
    private String description;

    ShareMode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
