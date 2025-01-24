package system.bld.service.permission;

import com.github.pagehelper.Page;
import system.bld.model.UserRole;
import system.bld.response.UserRoleRes;

import java.util.List;

/**
 * @author litao
 * @date 2021-04-16
 * @Desc
 */
public interface UserRoleService {

    /**
     *
     * @param userRole 
     * @return boolean
     * @author litao
     * @date 2021/4/16 17:10
     */
    boolean addUserRole(UserRole userRole);

    /**
     * 移除
     * @param userRole
     * @return boolean
     * @author litao
     * @date 2021/4/16 17:10
     */
    boolean delUserRole(UserRole userRole);

    /**
     * 查询用户的所属角色
     * @param userId
     * @return java.util.List<system.bld.response.UserRoleRes>
     * @author litao
     * @date 2021/4/16 17:50
     */
    List<UserRoleRes> queryUserRoleList(Long userId);

    /**
     * 查询 用户的角色-分页
     * @param userId
     * @return com.github.pagehelper.Page<system.bld.response.UserRoleRes>
     * @author litao
     * @date 2021/6/4 10:29
     */
    Page<UserRoleRes> queryUserRolePageList(Long userId);
}
