package system.bld.controller;

import cn.hutool.core.bean.BeanUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.bld.annotations.Login;
import system.bld.constans.ApplicationProperties;
import system.bld.enums.LoginEnum;
import system.bld.model.UserBase;
import system.bld.request.UserLoginReq;
import system.bld.request.base.MyToken;
import system.bld.response.APIResponse;
import system.bld.response.UserLoginInfoRes;
import system.bld.service.RedisService;
import system.bld.service.UserBaseService;
import system.bld.service.UserService;
import system.bld.utils.AesUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/5/12
 * @Time: 9:43
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RestController
@RequestMapping("/login")
public class LoginApiController extends BaseApiController {

	private static final Logger log= LoggerFactory.getLogger(BaseApiController.class);

	@Autowired
	UserBaseService userBaseService;

    @Autowired
	UserService userBase;

	@Autowired
    RedisService redisService;

    @Login(login= LoginEnum.Skip)
	@RequestMapping("/login")
	public APIResponse loginSubmit(HttpServletRequest request, HttpServletResponse response, @RequestBody @Valid UserLoginReq userLoginReq){
		//log.info("user login ");

        UserLoginInfoRes userLoginInfoRes= userBase.login(userLoginReq);

        MyToken myToken=new MyToken();

        myToken.setUserId(userLoginInfoRes.getUserId());

        myToken.setUserName(userLoginInfoRes.getUserName());

        String token= AesUtils.encrypt(ApplicationProperties.USER_LOGIN_AES_KEY,myToken);

        userLoginInfoRes.setAuthToken(token);

        setCookie(response,"authToken",token);

		return sucess(userLoginInfoRes);
	}

    /*@RequestMapping("/setRedis/{value}")
	public APIResponse getRedisList(@PathVariable("value") String value){

        log.info("LoginApiController getRedisList,value:{}",value);
        String key="test.bld.str";
        RList<String> rList= redisService.setStr(key);

        rList.add(value);
        List<String> res= rList.readAll();

	    return sucess(res);

    }*/
}
