package system.bld.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.digest.MD5;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import system.bld.annotations.Login;
import system.bld.constans.ApplicationProperties;
import system.bld.controller.base.BaseController;
import system.bld.enums.LoginEnum;
import system.bld.enums.UserPlatformEnum;
import system.bld.event.UserLoginLogEvent;
import system.bld.request.UserLoginReq;
import system.bld.request.base.MyToken;
import system.bld.request.user.UserLoginLogReq;
import system.bld.response.UserLoginInfoRes;
import system.bld.service.UserService;
import system.bld.service.user.UserLoginLogService;
import system.bld.utils.AesUtils;
import system.bld.utils.IPUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/25
 * @Time: 19:21
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	private static final Logger log= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userBase;

    @Autowired
    private ApplicationContext eventPublisher;

    @Login(login= LoginEnum.Skip)
	@RequestMapping("")
	public String home(HttpServletRequest request, Model model){
		log.info("enter user login page");

		return "login/login";
	}

    @Login(login= LoginEnum.Skip)
    @RequestMapping("/login")
	public String loginSubmit(HttpServletRequest request, UserLoginReq userLoginReq, HttpServletResponse response){
        log.info("login submit ,userLoginReq:{}", JSON.toJSONString(userLoginReq));

        UserLoginInfoRes userLoginInfoRes= userBase.login(userLoginReq);

        if(userLoginInfoRes==null){
            Assert.isTrue(false,"账号密码错误");
        }

        UserLoginLogReq userLoginLogReq =new UserLoginLogReq();

        userLoginLogReq.setUserId(userLoginInfoRes.getUserId());

        userLoginLogReq.setUserName(userLoginInfoRes.getUserName());

        userLoginLogReq.setMobilePhone(userLoginInfoRes.getMobilePhone());

        userLoginLogReq.setPlatform(UserPlatformEnum.USER_BACKEND.getType());

        userLoginLogReq.setIp(IPUtils.getIpAddress(request));

        UserLoginLogEvent event=new UserLoginLogEvent(this);
        event.setUserLoginLogReq(userLoginLogReq);
        eventPublisher.publishEvent(event);


        MyToken myToken=new MyToken();

        myToken.setUserId(userLoginInfoRes.getUserId());

        myToken.setUserName(userLoginInfoRes.getUserName());

        String token= AesUtils.encrypt(ApplicationProperties.USER_LOGIN_AES_KEY_WEB,myToken);

        userLoginInfoRes.setAuthToken(token);

        setCookie(response,"authToken",token);

        return "redirect:/home";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {

	    Long userId=getUserId(request);

        log.info("login out userId:{}",userId);

        removeCookie(response,"authToken");

        return "login/login";
    }
}
