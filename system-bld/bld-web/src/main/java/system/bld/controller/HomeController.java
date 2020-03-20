package system.bld.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.bld.entiry.UserEntity;
import system.bld.service.UserService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/20
 * @Time: 15:29
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping("/index")
	public String home(HttpServletRequest request, String string){

		UserEntity result= userService.getUserById(1);
		return "hello user info : ".concat(result.toString());
	}
}
