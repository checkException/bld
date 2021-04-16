package system.bld.service.permission;

import com.baomidou.mybatisplus.service.IService;
import system.bld.model.Role;

/**
 * @author litao
 * @date 2021-04-16
 * @Desc
 */
public interface RoleService extends IService<Role>{

    /**
     *
     * @param role 
     * @return java.lang.Boolean
     * @author litao
     * @date 2021/4/16 16:57
     */
    Boolean addRole(Role role);

   
    /**
     *
     * @param role
     * @return java.lang.Boolean
     * @author litao
     * @date 2021/4/16 17:02
     */
    Boolean editRole(Role role);
}
