package system.bld.event;

import org.springframework.context.ApplicationEvent;
import system.bld.request.user.UserLoginLogReq;

/**
 * @author litao
 * @date 2021-09-27
 * @Desc
 */
public class UserLoginLogEvent extends ApplicationEvent{

    private UserLoginLogReq userLoginLogReq;

    public UserLoginLogEvent(Object source) {
        super(source);
    }

    public UserLoginLogReq getUserLoginLogReq() {
        return userLoginLogReq;
    }

    public void setUserLoginLogReq(UserLoginLogReq userLoginLogReq) {
        this.userLoginLogReq = userLoginLogReq;
    }
}
