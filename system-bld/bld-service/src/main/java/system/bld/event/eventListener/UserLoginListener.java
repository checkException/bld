package system.bld.event.eventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import system.bld.event.UserLoginLogEvent;
import system.bld.service.user.UserLoginLogService;

/**
 * @author litao
 * @date 2021-09-27
 * @Desc
 */
@Component
public class UserLoginListener {

    public static final Logger logger = LoggerFactory.getLogger(UserLoginListener.class);

    @Autowired
    UserLoginLogService userLoginLogService;

    @EventListener
    public void processUserLoginLogListener(UserLoginLogEvent userLoginLogEvent){

        logger.info("enter UserLoginListener.processUserLoginLogListener ,userLoginLogEvent:{}",userLoginLogEvent);

        userLoginLogService.saveLoginLog(userLoginLogEvent.getUserLoginLogReq());
    }
}
