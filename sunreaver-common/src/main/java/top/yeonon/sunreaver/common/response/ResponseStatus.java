package top.yeonon.sunreaver.common.response;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 22:35
 **/
public enum  ResponseStatus {
    //success code 0
    SUCCESS(0, "response success"),

    //common error code 1 - 99
    ERROR(1, "response error"),
    REQUEST_PARAM_ERROR(2, "request parameter(s) error!"),

    //user service error code 100-199
    USERNAME_ALREADY_EXISTS(100, "username already exists!"),
    USERNAME_OR_PASSWORD_ERROR(101, "username or password error!"),
    NOT_EXIST_USER(102, "doesn't exist this user!"),

    //auth service error code 200-299
    NOT_EXIST_TOKEN_IN_HEAD(200, "here is no token in the header!"),
    NOT_ALLOW_ACTION(201, "doesn't allow the action!"),
    ;

    //TODO: add more enum

    private int code;
    private String description;

    ResponseStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
