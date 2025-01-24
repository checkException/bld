package system.bld.controller;

import cn.hutool.core.bean.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.bld.model.UserRole;
import system.bld.request.UserRoleReq;
import system.bld.response.APIPageResponse;
import system.bld.response.APIResponse;
import system.bld.response.UserRoleRes;
import system.bld.service.permission.UserRoleService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author litao
 * @date 2021-05-28
 * @Desc
 */
@RestController
@RequestMapping("/role")
public class UserRoleController  extends BaseApiController{

    private static final Logger log= LoggerFactory.getLogger(UserRoleController.class);

    @Autowired
    UserRoleService userRoleService;

    @RequestMapping("/user/pageList")
    public APIPageResponse queryRolePageList(HttpServletRequest request){

        Long userId=100L;
        userRoleService.queryUserRolePageList(userId);
        return null;
    }

    @RequestMapping("/user/list")
    public APIResponse queryRoleList(HttpServletRequest request){

        Long userId=100L;

        List<UserRoleRes> resList= userRoleService.queryUserRoleList(userId);

        return sucess(resList);
    }

    @RequestMapping("/user/add")
    public APIResponse addUserRole(HttpServletRequest request,@RequestBody UserRoleReq userRoleReq){

        UserRole userRole=new UserRole();

        BeanUtil.copyProperties(userRoleReq,userRole);

        Boolean response= userRoleService.addUserRole(userRole);

        return sucess(response);
    }

    @RequestMapping("/user/del")
    public APIResponse delUserRole(HttpServletRequest request,@RequestBody UserRoleReq userRoleReq){

        UserRole userRole=new UserRole();

        BeanUtil.copyProperties(userRoleReq,userRole);

        Boolean response= userRoleService.delUserRole(userRole);

        return sucess(response);
    }
}
