package system.bld.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import system.bld.entiry.UserEntity;

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
public interface UserDao extends BaseMapper<UserEntity>{

	/**
	 * 获取用户信息根据id
	 * @param id
	 * @return
	 */
	UserEntity getUserById(Integer id);
}
