package top.yeonon.sunreaver.common.exception;

/**
 * @Author yeonon
 * @date 2019/10/12 0012 23:05
 **/
public class SunreaverException extends RuntimeException {

    private Integer errorCode;

    public SunreaverException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
