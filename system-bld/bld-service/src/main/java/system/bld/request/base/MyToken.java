package system.bld.request.base;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @author litao
 * @date 2020-12-30
 * @Desc
 */
public class MyToken implements Serializable {


    private static final long serialVersionUID = 1632031162648865237L;

    private Long userId;

    private String userName;

    private String mobilePhone;

    /**
     * 登陆日期
     */
    private String LoginDateDay;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getLoginDateDay() {
        return LoginDateDay;
    }

    public void setLoginDateDay(String loginDateDay) {
        LoginDateDay = loginDateDay;
    }
}
