package top.yeonon.yclouddisk.common.response;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 22:35
 **/
public enum  ResponseStatus {
    //success code
    SUCCESS(200, "response success"),

    //error code 0 - 99
    ERROR(0, "response error"),
    REQUEST_PARAM_ERROR(1, "request parameter(s) error!"),
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
