package system.bld.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import system.bld.AppTest;
import system.bld.model.UserBase;

import static org.junit.Assert.*;


public class UserServiceTest extends AppTest{

	@Autowired
	UserService userService;

	@Test
	public void getStr() throws Exception {
	}

	@Test
	public void getUserById() throws Exception {
		UserBase userBase=userService.getUserById(1L);

		System.out.println("---------------".concat(userBase.getMobilePhone()));
	}

}