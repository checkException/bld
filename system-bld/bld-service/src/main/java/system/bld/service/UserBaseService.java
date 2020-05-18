package system.bld.service;

import system.bld.model.UserBase;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/5/11
 * @Time: 15:38
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface UserBaseService {

	/**
	 * 查询 根据用户id
	 * @param id
	 * @return
	 */
	UserBase queryUserById(Long id);

}
