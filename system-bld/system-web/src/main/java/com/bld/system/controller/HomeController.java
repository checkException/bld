package com.bld.system.controller;

import com.bld.system.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/16
 * @Time: 11:16
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RestController
@RequestMapping("/home")
public class HomeController {

	private static final Logger logger= LoggerFactory.getLogger(HomeController.class);

	@Autowired
	HomeService homeService;


	@RequestMapping("/index/{type}")
	public String index(HttpServletRequest request, @PathVariable("type") Integer type){
		logger.info(" test first page ");

		return homeService.getMsd(type);
	}
}
