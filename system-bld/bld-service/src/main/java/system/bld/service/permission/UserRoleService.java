package system.bld.service.permission;

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
}
