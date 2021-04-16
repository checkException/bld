package system.bld.service.impl.permission;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import system.bld.dao.RoleDao;
import system.bld.enums.ErrorCodeEnum;
import system.bld.model.Role;
import system.bld.service.permission.RoleService;
import system.common.utils.UUIDUtils;

import java.util.Date;

/**
 * @author litao
 * @date 2021-04-16
 * @Desc
 */
public class RoleServiceImpl extends ServiceImpl<RoleDao,Role> implements RoleService {
    private static final Logger log= LoggerFactory.getLogger(RoleServiceImpl.class);

    /*@Autowired
    RoleDao roleDao;*/


    @Override
    public Boolean addRole(Role role) {

        log.info("RoleServiceImpl.addRole,role:{}",role.toString());

        Assert.isNull(role.getRoleName(), ErrorCodeEnum.ILLEGAL_ARGUMENT.getResponseMsg());

        role.setCreateTime(new Date());

        role.setModifyTime(new Date());

        role.setStatus(0);

        role.setRoleCode(UUIDUtils.randomUUID());

        return super.insert(role);
    }

    @Override
    public Boolean editRole(Role role) {

        log.info("RoleServiceImpl.editRole,role:{}",role.toString());

        Assert.isNull(role.getId(), ErrorCodeEnum.ILLEGAL_ARGUMENT.getResponseMsg());

        role.setModifyTime(new Date());

        return super.updateById(role);
    }

}
