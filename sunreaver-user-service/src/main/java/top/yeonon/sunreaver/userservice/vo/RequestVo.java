package top.yeonon.sunreaver.userservice.vo;

/**
 * @Author yeonon
 * @date 2019/10/16 0016 22:25
 **/
public interface RequestVo {

    default boolean validate() {
        return true;
    }

}
