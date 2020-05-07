package system.bld.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bld.dao.UserDao;
import system.bld.entiry.UserBean;
import system.bld.entiry.UserEntity;
import system.bld.service.UserService;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/20
 * @Time: 14:51
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao,UserEntity> implements UserService {

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
	public UserEntity getUserById(Integer id) {
		UserEntity userEntity=new UserEntity();
		userEntity.setId(id);
		return userDao.getUserById(userEntity.getId());
	}

}
