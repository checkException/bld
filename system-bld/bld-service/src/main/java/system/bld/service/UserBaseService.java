package system.bld.service;

import com.github.pagehelper.Page;
import system.bld.model.UserBase;
import system.bld.request.UserBaseReq;

import java.util.List;

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

    List<UserBase> queryList();

    Page<UserBase> queryListPage(UserBaseReq userBaseReq);

	Boolean addUserBase(UserBase userBase);
}
