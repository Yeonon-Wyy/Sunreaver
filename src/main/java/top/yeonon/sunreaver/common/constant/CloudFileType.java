package top.yeonon.sunreaver.common.constant;

/**
 * @Author yeonon
 * @date 2019/10/16 0016 21:29
 **/
public enum CloudFileType {
    NONE(0, "none"),
    TEXT(1, "text"),
    VIDEO(2, "video"),
    IMAGE(3, "image"),
    BIN(4, "bin")
    ;


    CloudFileType(int code, String description) {
        this.code = code;
        this.description = description;
    }

    private int code;
    private String description;
}
