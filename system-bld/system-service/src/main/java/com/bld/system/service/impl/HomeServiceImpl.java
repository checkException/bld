package com.bld.system.service.impl;

import com.bld.system.service.HomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/16
 * @Time: 13:19
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class HomeServiceImpl implements HomeService {

	private static final Logger logger= LoggerFactory.getLogger(HomeServiceImpl.class);


	@Override
	public String getMsd(Integer type) {
		logger.info(" -- type:{}",type);
		String resultStr="default";
		switch (type){
			case 1:
				resultStr="valus=1";
				break;
			case 2:
				resultStr="valus=2";
				break;
			case 3:
				resultStr="valus=3";
				break;
		}

		return resultStr;
	}
}
