package system.bld.controller.user;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import system.bld.controller.base.BaseController;
import system.bld.enums.ErrorCodeEnum;
import system.bld.model.UserBase;
import system.bld.model.UserPassword;
import system.bld.request.UserBaseReq;
import system.bld.response.APIPageResponse;
import system.bld.response.APIResponse;
import system.bld.service.UserBaseService;
import system.bld.service.user.UserPasswordService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author litao
 * @date 2020-12-02
 * @Desc
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserBaseService userBaseService;
    @Autowired
    UserPasswordService userPasswordService;

    @RequestMapping("/list")
    public String queryList(HttpServletRequest request, @RequestBody(required = false) UserBaseReq userBaseReq, Model model){
        //Page<UserBase> listPage= userBaseService.queryListPage(userBaseReq);
        List<UserBase> list= userBaseService.queryList();
        model.addAttribute("userList",list);

        return "user/user-list";
    }

    /**
     * 添加
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public String userAdd(HttpServletRequest request){
        logger.info("enter UserController.userAdd,operatiorId:{}",getUserId(request));

        return "user/user_add";

    }

    /**
     * 添加
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/add/submit")
    public APIResponse userAddSubmit(HttpServletRequest request,@RequestBody UserBaseReq userBaseReq){

        logger.info("enter UserController.userAddSubmit,operatiorId:{},userBaseReq:{}",getUserId(request), JSON.toJSONString(userBaseReq));

        UserBase userBase =new UserBase();

        BeanUtil.copyProperties(userBaseReq,userBase);

        if(userBaseService.addUserBase(userBase)){

            UserPassword userPassword =new UserPassword();

            userPassword.setUserId(userBase.getId());

            userPassword.setUserName(userBase.getUserName());

            userPassword.setLoginPassword("a123456");

            userPasswordService.addPassword(userPassword);
        }

        return sucess(Boolean.TRUE);

    }

    /**
     * 编辑
     * @param request
     * @return
     */
    /*@RequestMapping("/edit/{id}")
    public String userEdit(HttpServletRequest request, @PathVariable("id") Long id, Model model){
        logger.info("enter UserController.userEdit,operatiorId:{},id：{}",getUserId(request),id);

        return "user/user_edit";

    }*/

    /**
     * 编辑
     * @param request
     * @return
     */
    @RequestMapping("/edit")
    public String userEdit(HttpServletRequest request, @RequestParam("id") Long id, Model model){
        logger.info("enter UserController.userEdit.id：{}",id);
        if(ObjectUtil.isNull(id)){
            Assert.isTrue(false, ErrorCodeEnum.ILLEGAL_ARGUMENT.getResponseMsg());
        }

        UserBase userBase = userBaseService.queryUserById(id);
        model.addAttribute("userBase",userBase);
        return "user/user_edit";

    }

    /**
     * 添加
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/edit/submit")
    public APIResponse userEditSubmit(HttpServletRequest request,@RequestBody UserBaseReq userBaseReq){

        logger.info("enter UserController.userEditSubmit.userBaseReq:{}", JSON.toJSONString(userBaseReq));

        UserBase userBase =new UserBase();

        BeanUtil.copyProperties(userBaseReq,userBase);

        Boolean result = userBaseService.editUserBase(userBase);

        return sucess(result);

    }
}
