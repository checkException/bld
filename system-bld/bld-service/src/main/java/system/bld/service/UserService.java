package system.bld.service;

import com.baomidou.mybatisplus.service.IService;
import system.bld.model.UserBase;
import system.bld.request.UserLoginReq;
import system.bld.response.UserLoginInfoRes;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/20
 * @Time: 14:50
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface UserService extends IService<UserBase> {

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
	UserBase getUserById(Long id);

    /**
     * 登录
     * @param userLoginReq
     * @return
     */
    UserLoginInfoRes login(UserLoginReq userLoginReq);
}
