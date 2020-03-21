package system.bld.controller;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.bld.entiry.UserEntity;
import system.bld.service.UserService;

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
public class HomeController {
	private static final Logger log= LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserService userService;

	@RequestMapping("/index")
	public String home(HttpServletRequest request, String string, Model model){

		UserEntity result= userService.getUserById(1);
		//return "hello user info : ".concat(result.toString());
		log.info("------------------");
		model.addAttribute("id","123");
		model.addAttribute("name","litao");
		model.addAttribute("desc","test");
		return "index";
	}
}
