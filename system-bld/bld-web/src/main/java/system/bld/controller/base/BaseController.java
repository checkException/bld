package system.bld.controller.base;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import system.bld.constans.ApplicationProperties;
import system.bld.enums.ErrorCodeEnum;
import system.bld.request.base.MyToken;
import system.bld.response.APIPageResponse;
import system.bld.response.APIResponse;
import system.bld.utils.AesUtils;
import system.common.utils.ResultHandle;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author litao
 * @date 2021-08-31
 * @Desc
 */
public class BaseController {

    protected APIResponse sucess(Object o){

        return new APIResponse(200,"请求成功",o);
    }

    protected void setCookie(HttpServletResponse response, String key, String value){
        Cookie cookie = new Cookie(key, value);
        //cookie.setDomain("127.0.0.1");
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    protected void removeCookie(HttpServletResponse response, String key){
        Cookie cookie = new Cookie(key, null);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    protected Long getUserId(HttpServletRequest request){

        MyToken myToken=getMytoken(request);

        if(myToken==null){
            Assert.isTrue(false,"系统异常");
        }

        return myToken.getUserId();
    }

    protected MyToken getMytoken(HttpServletRequest request){
        String authToken="";

        Cookie[] cookies = request.getCookies();

        if (ObjectUtil.isNotNull(cookies) && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                if ("authToken".equals(cookie.getName())) {
                    authToken=cookie.getValue();

                    break;
                }
            }
        }

        String json= AesUtils.decrypt(ApplicationProperties.USER_LOGIN_AES_KEY_WEB,authToken);

        if(json==null || "".equals(json)){
            return null;
        }
        MyToken myToken= JSON.parseObject(json,MyToken.class);

        return myToken;
    }

    /**
     *
     * @param page
     * @return
     */
    protected APIPageResponse successPage(Page page){

        APIPageResponse response=new APIPageResponse(200,"请求成功",page.getResult());

        response.setPages(page.getPages());

        response.setTotalCount(page.getTotal());

        response.setCurrentPages(page.getPageNum());

        return response;
    }
}
