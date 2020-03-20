package system.bld.service;

import com.baomidou.mybatisplus.service.IService;
import system.bld.entiry.UserEntity;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/20
 * @Time: 14:50
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface UserService extends IService<UserEntity> {

	/**
	 * test service 实现是否生效
	 * @param str
	 * @return
	 */
	String getStr(String str);

	/**
	 * 获取信息
	 * @param id
	 * @return
	 */
	UserEntity getUserById(Integer id);

}
