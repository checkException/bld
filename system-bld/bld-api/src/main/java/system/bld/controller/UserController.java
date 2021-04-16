package system.bld.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.bld.model.UserBase;
import system.bld.request.UserBaseReq;
import system.bld.response.APIPageResponse;
import system.bld.response.APIResponse;
import system.bld.service.UserBaseService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author litao
 * @date 2020-12-02
 * @Desc
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseApiController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserBaseService userBaseService;


    @RequestMapping("/list")
    public APIPageResponse queryList(HttpServletRequest request, @RequestBody(required = false) UserBaseReq userBaseReq){
        logger.info("UserController.queryList,userBaseReq:{}", JSON.toJSONString(userBaseReq));
        if(ObjectUtil.isNull(userBaseReq)){
            //return new APIPageResponse(200,"成功",null);
        }

        Page<UserBase> listPage= userBaseService.queryListPage(userBaseReq);
        logger.info("out UserController.queryList");
        return sucessPage(listPage);
    }

    /**
     * 添加
     * @param request
     * @param userBaseReq
     * @return
     */
    @RequestMapping("/add")
    public APIResponse userAdd(HttpServletRequest request, @RequestBody @Valid UserBaseReq userBaseReq){

        UserBase userBase=new UserBase();

        BeanUtil.copyProperties(userBaseReq,userBase);

        Boolean result= userBaseService.addUserBase(userBase);

        return sucess(result);

    }

}
