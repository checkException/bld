package system.bld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import system.bld.annotations.Login;
import system.bld.enums.LoginEnum;

import javax.servlet.http.HttpServletRequest;

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
public class LoginController {
	private static final Logger log= LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("")
	public String home(HttpServletRequest request, Model model){
		log.info("user login ");

		return "login/login";
	}
}
