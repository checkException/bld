package system.bld.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bld.dao.UserBaseDao;
import system.bld.model.UserBase;
import system.bld.service.UserBaseService;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/5/11
 * @Time: 15:38
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Service
public class UserBaseServiceImpl implements UserBaseService {
	@Autowired
	UserBaseDao userBaseDao;

    /**
     * 查询 根据用户id
     *
     * @param id
     * @return
     */
	@Override
	public UserBase queryUserById(Long id) {
		return userBaseDao.selectByPrimaryKey(id);
	}
}
