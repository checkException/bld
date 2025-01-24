package system.bld.controller;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import system.bld.annotations.Login;
import system.bld.controller.base.BaseController;
import system.bld.enums.LoginEnum;
import system.bld.model.UserBase;
import system.bld.service.UserBaseService;
import system.bld.service.UserService;
import system.bld.service.user.UserLoginLogService;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/20
 * @Time: 15:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{
	private static final Logger log= LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserService userService;
	@Autowired
	UserBaseService userBaseService;

	@Autowired
    UserLoginLogService userLoginLogService;

    //@Login(login= LoginEnum.Skip)
	@RequestMapping("")
	public String home(HttpServletRequest request,  Model model){

	    Long userId=getUserId(request);

		UserBase result= userService.getUserById(userId);

		log.info("------------------");
		model.addAttribute("id",result.getId());
		model.addAttribute("name",result.getUserName());
		model.addAttribute("mobilePhone",result.getMobilePhone());
		return "main";
	}


	//@Login(login= LoginEnum.Skip)
	@RequestMapping("/index")
	public String index(HttpServletRequest request, String string, Model model){
        Long userId=getUserId(request);

		UserBase result= userBaseService.queryUserById(userId);
		log.info("------------------");
		model.addAttribute("id",result.getId());
		model.addAttribute("name",result.getUserName());
		model.addAttribute("mobilePhone",result.getMobilePhone());
		model.addAttribute("userBase",result);

		model.addAttribute("loginLogList",userLoginLogService.queryListLimit100());
		return "index";
	}

	@ResponseBody
	@RequestMapping("/page")
	public Page<UserBase> queryPage(HttpServletRequest request, Model model){
		UserBase userBase =new UserBase();
		userBase.setId(1L);

		Map<String ,Object> param= BeanUtil.beanToMap(userBase);

		Page<UserBase> userBasePage=new Page<>(1,10);
		userBasePage.setCondition(param);

		Page<UserBase> resultPage= userService.selectPage(userBasePage);

		log.info("resultPage:{}",resultPage);

		return resultPage;
	}
}
