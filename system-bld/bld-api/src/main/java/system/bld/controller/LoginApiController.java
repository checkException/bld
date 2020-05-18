package system.bld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.bld.model.UserBase;
import system.bld.response.APIResponse;
import system.bld.service.UserBaseService;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping("/submit")
	public APIResponse loginSubmit(HttpServletRequest request, Model model){
		log.info("user login ");
		UserBase userBase= userBaseService.queryUserById(1L);
		return sucess(userBase);
	}

}
