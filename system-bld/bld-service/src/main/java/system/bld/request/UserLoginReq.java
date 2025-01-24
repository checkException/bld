package system.bld.request;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author litao
 * @date 2020-12-03
 * @Desc
 */
public class UserLoginReq implements Serializable {
    private static final long serialVersionUID = 6670508002029907119L;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobilePhone;

    /**
     * 登录类型- 1 账号密码；2 手机号；
     */
    private Integer loginType;

    /**
     * 校验码
     */
    private String verifyCode;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public Integer getLoginType() {
        return loginType;
    }

    public void setLoginType(Integer loginType) {
        this.loginType = loginType;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
