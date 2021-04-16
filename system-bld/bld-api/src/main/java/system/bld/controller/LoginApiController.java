package system.bld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.bld.model.UserBase;
import system.bld.request.UserLoginReq;
import system.bld.response.APIResponse;
import system.bld.response.UserLoginInfoRes;
import system.bld.service.RedisService;
import system.bld.service.UserBaseService;
import system.bld.service.UserService;

import javax.servlet.http.HttpServletRequest;
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

	UserService userBase;

	@Autowired
    RedisService redisService;


	@RequestMapping("/login")
	public APIResponse loginSubmit(HttpServletRequest request,@RequestBody @Valid UserLoginReq userLoginReq){
		//log.info("user login ");

        UserLoginInfoRes userLoginInfoRes= userBase.login(userLoginReq);

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
