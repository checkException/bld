package system.bld.service.impl.permission;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Assert;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bld.dao.RoleDao;
import system.bld.dao.UserRoleDao;
import system.bld.enums.ErrorCodeEnum;
import system.bld.model.Role;
import system.bld.model.UserRole;
import system.bld.response.UserRoleRes;
import system.bld.service.permission.UserRoleService;
import system.common.utils.BeanConvertUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author litao
 * @date 2021-04-16
 * @Desc
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    private static final Logger log= LoggerFactory.getLogger(UserRoleServiceImpl.class);

    @Autowired
    UserRoleDao userRoleDao;

    @Autowired
    RoleDao roleDao;


    /**
     * @param userRole
     * @return boolean
     * @author litao
     * @date 2021/4/16 17:10
     */
    @Override
    public boolean addUserRole(UserRole userRole) {

        log.info("UserRoleServiceImpl.addUserRole,userRole:{}",userRole.toString());

        Assert.isNull(userRole.getRoleId(), ErrorCodeEnum.ILLEGAL_ARGUMENT.getResponseMsg());

        Assert.isNull(userRole.getUserId(), ErrorCodeEnum.ILLEGAL_ARGUMENT.getResponseMsg());

        userRole.setCreateTime(new Date());

        return userRoleDao.insert(userRole)>0?true:false;
    }

    /**
     * 移除
     *
     * @param userRole
     * @return boolean
     * @author litao
     * @date 2021/4/16 17:10
     */
    @Override
    public boolean delUserRole(UserRole userRole) {
        log.info("UserRoleServiceImpl.delUserRole,userRole:{}",userRole.toString());

        Assert.isNull(userRole.getId(), ErrorCodeEnum.ILLEGAL_ARGUMENT.getResponseMsg());

        return userRoleDao.deleteByPrimaryKey(userRole.getId())>0?true:false;
    }

    /**
     * 查询用户的所属角色
     *
     * @param userId
     * @return java.util.List<system.bld.response.UserRoleRes>
     * @author litao
     * @date 2021/4/16 17:50
     */
    @Override
    public List<UserRoleRes> queryUserRoleList(Long userId) {

        List<UserRole> userRoleList= userRoleDao.queryListByUserId(userId);

        if(CollectionUtil.isEmpty(userRoleList)){

            return null;
        }

        List<Long> roleIdList= userRoleList.stream().map(UserRole::getRoleId).collect(Collectors.toList());

        List<Role> roleList= roleDao.selectListByRoleIds(roleIdList);

        return BeanConvertUtils.convertList(roleList,UserRoleRes.class);
    }

    /**
     * 查询 用户的角色-分页
     *
     * @param userId
     * @return com.github.pagehelper.Page<system.bld.response.UserRoleRes>
     * @author litao
     * @date 2021/6/4 10:29
     */
    @Override
    public Page<UserRoleRes> queryUserRolePageList(Long userId) {

        return null;
    }


}
