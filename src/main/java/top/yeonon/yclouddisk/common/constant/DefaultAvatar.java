package top.yeonon.yclouddisk.common.constant;

/**
 * @Author yeonon
 * @date 2019/10/11 0011 23:11
 **/
public enum DefaultAvatar {


    DEFAULT_FUZZY_AVATAR(UserSex.FUZZY.getCode(), "http://avatar.ycloudDisk.com/defatlt_fuzzy_avatar.png"),
    DEFAULT_MALE_AVATAR(UserSex.MALE.getCode(), "http://avatar.ycloudDisk.com/defatlt_male_avatar.png"),
    DEFAULT_FEMALE_AVATAR(UserSex.FEMALE.getCode(), "http://avatar.ycloudDisk.com/defatlt_female_avatar.png");

    private Integer userSexCode;
    private String address;

    DefaultAvatar(Integer userSexCode, String address) {
        this.userSexCode = userSexCode;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Integer getUserSexCode() {
        return userSexCode;
    }

    public static String getAddress(Integer userSexCode) {
        for (DefaultAvatar defaultAvatar : values()) {
            if (defaultAvatar.getUserSexCode().equals(userSexCode)) {
                return defaultAvatar.getAddress();
            }
        }
        return "";
    }
}
