package system.bld.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bld.dao.UserBaseDao;
import system.bld.dao.UserDao;
import system.bld.model.UserBase;
import system.bld.service.UserService;

/**
 * Created with IntelliJ IDEA.
 * 可以继承ServiceImpl   用一些公用方法，也不可以不继承，自己写SQL
 * @Author: LiTao
 * @Date: 2020/3/20
 * @Time: 14:51
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao,UserBase> implements UserService {

	@Autowired
	UserDao userDao;


	/**
	 * test service 实现是否生效
	 * 实现
	 * @param str
	 * @return
	 */
	@Override
	public String getStr(String str) {
		return str;
	}

	/**
	 * 获取信息
	 *
	 * @param id
	 * @return
	 */
	@Override
	public UserBase getUserById(Long id) {
		UserBase userEntity=new UserBase();
		userEntity.setId(id);
		return userDao.getUserById(userEntity.getId());
	}



}
