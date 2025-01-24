package system.bld.controller;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import system.bld.enums.ErrorCodeEnum;
import system.bld.request.base.MyToken;
import system.bld.response.APIPageResponse;
import system.bld.response.APIResponse;
import system.bld.utils.AesUtils;
import system.common.utils.ResultHandle;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/5/12
 * @Time: 9:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class BaseApiController {


	protected APIResponse sucess(Object o){

		return new APIResponse(200,"请求成功",o);
	}

    /**
     *
     * @param page
     * @return
     */
    protected APIPageResponse sucessPage(Page page){

        APIPageResponse response=new APIPageResponse(200,"请求成功",page.getResult());

        response.setPages(page.getPages());

        response.setTotalCount(page.getTotal());

        response.setCurrentPages(page.getPageNum());

        return response;
    }

    protected void setCookie(HttpServletResponse response,String key,String value){
        Cookie cookie = new Cookie(key, value);
        //cookie.setDomain("127.0.0.1");
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    protected Long getUserId(HttpServletRequest request,HttpServletResponse response){

        Object obj=request.getAttribute("userId");

        if(obj==null){
            MyToken myToken=getMytoken(request);

            if(myToken==null){
                processAjaxResponse(response, ResultHandle.fail(ErrorCodeEnum.NOT_LOGIN));
            }

            return myToken.getUserId();
        }
        return Long.valueOf(obj.toString());
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

        String json= AesUtils.decrypt("systembld",authToken);

        if(json==null || !"".equals(json)){
            return null;
        }
        MyToken myToken= JSON.parseObject(json,MyToken.class);

        return myToken;
    }

    private void processAjaxResponse(HttpServletResponse response, Object result) {

        response.setContentType("text/plain; charset=utf-8");

        response.setCharacterEncoding("UTF-8");

        response.setHeader("Access-Control-Allow-Credentials", "true");

        response.setHeader("Access-Control-Allow-Origin", response.getHeader("Origin"));
        PrintWriter out = null;

        try {

            out = response.getWriter();

            out.write(JSON.toJSONString(result));

        } catch (IOException e) {

        } finally {

            if (out != null) {

                out.close();
            }
        }
    }

}
