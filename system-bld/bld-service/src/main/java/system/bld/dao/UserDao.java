package system.bld.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import system.bld.model.UserBase;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/20
 * @Time: 14:46
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Repository
public interface UserDao extends BaseMapper<UserBase>{

	/**
	 * 获取用户信息根据id
	 * @param id
	 * @return
	 */
	UserBase getUserById(Long id);
}
