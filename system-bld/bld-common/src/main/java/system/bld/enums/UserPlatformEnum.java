package system.bld.enums;

/**
 * @author litao
 * @date 2021-09-24
 * @Desc
 */
public enum  UserPlatformEnum {

    USER_BACKEND("10","用户后台");

    private String type;

    private String description;

    UserPlatformEnum(final String type, final String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

}
