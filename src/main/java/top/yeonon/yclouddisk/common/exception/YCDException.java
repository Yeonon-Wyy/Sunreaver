package top.yeonon.yclouddisk.common.exception;

/**
 * @Author yeonon
 * @date 2019/10/12 0012 23:05
 **/
public class YCDException extends RuntimeException {

    private Integer errorCode;

    public YCDException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
