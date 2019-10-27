package top.yeonon.sunreaver.common.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 22:30
 **/
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceResponse<T> {

    private Integer status;
    private String message;
    private T data;

    private ServiceResponse() {

    }

    private ServiceResponse(int status) {
        this.status = status;
    }

    private ServiceResponse(int status, String message) {
        this(status);
        this.message = message;
    }

    private ServiceResponse(int status, T data) {
        this(status);
        this.data = data;
    }

    private ServiceResponse(int status, String message, T data) {
        this(status, data);
        this.message = message;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == ResponseStatus.SUCCESS.getCode();
    }

    //success response

    public static <T> ServiceResponse<T> success(String message, T data) {
        return new ServiceResponse<>(ResponseStatus.SUCCESS.getCode(), message, data);
    }

    public static <T> ServiceResponse<T> success(T data) {
        return new ServiceResponse<>(ResponseStatus.SUCCESS.getCode(),
                ResponseStatus.SUCCESS.getDescription(),
                data);
    }

    public static <T> ServiceResponse success(String message) {
        return new ServiceResponse<T>(ResponseStatus.SUCCESS.getCode(), message);
    }

    public static <T> ServiceResponse success() {
        return new ServiceResponse<>(ResponseStatus.SUCCESS.getCode());
    }

    //error response

    public static <T> ServiceResponse error(String message) {
        return new ServiceResponse<>(ResponseStatus.ERROR.getCode(), message);
    }

    public static <T> ServiceResponse error(Integer errorStatusCode, String message) {
        return new ServiceResponse<>(errorStatusCode, message);
    }

    public static <T> ServiceResponse error() {
        return new ServiceResponse<T>(ResponseStatus.ERROR.getCode(), ResponseStatus.ERROR.getDescription());
    }



}
