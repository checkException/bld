package com.bld.system.systemservice;

import com.bld.system.service.HomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SystemServiceApplicationTests {

	@Autowired
	HomeService homeService;

	@Test
	void contextLoads() {
		System.out.println(homeService.getMsd(2));
	}

}
