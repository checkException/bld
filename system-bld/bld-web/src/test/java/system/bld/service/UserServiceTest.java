package system.bld.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import system.bld.AppTest;
import system.bld.model.UserBase;
import system.bld.utils.ExcelOperatorUtil;


public class UserServiceTest extends AppTest{

	@Autowired
	UserService userService;

	@Test
	public void getStr() throws Exception {
	}

	@Test
	public void getUserById() throws Exception {
		UserBase userBase=userService.getUserById(1L);

		if(userBase!=null){
			System.out.println("---------------".concat(userBase.getMobilePhone()));
		}

	}

	@Test
	public void excelOperator(){
		ExcelOperatorUtil.importExcel();
	}
}