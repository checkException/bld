package system.bld.interceptor;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import system.bld.annotations.Login;
import system.bld.constans.ApplicationProperties;
import system.bld.enums.LoginEnum;
import system.bld.request.base.MyToken;
import system.bld.utils.AesUtils;
import system.bld.utils.IPUtils;
import system.common.utils.UUIDUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * 登录拦截
 * @Author: LiTao
 * @Date: 2020/3/26
 * @Time: 9:52
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class LoginInterceptor implements HandlerInterceptor{
	private static final Logger log= LoggerFactory.getLogger(LoginInterceptor.class);

	/**
	 * 该方法的执行时机是，当某个 URL 已经匹配到对应的 Controller 中的某个方法，
	 * 且在这个方法执行之前。所以 preHandle(……) 方法可以决定是否将请求放行，这是通过返回值来决定的，返回 true 则放行，返回 false 则不会向后执行。
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //塞入 进程 唯一id
        MDC.put("apiTraceId", UUIDUtils.randomUUID());

        log.info("LoginInterceptor enter ..... url:{}",request.getRequestURI());

		if(handler instanceof HandlerMethod){
			Login login= ((HandlerMethod) handler).getMethodAnnotation(Login.class);

			if(ObjectUtil.isNotNull(login)){
				//免校验 跳过验证
				if(login.login()== LoginEnum.Skip){
					return true;
				}
			}

            String authToken="";
            //取token
            Cookie[] cookies = request.getCookies();
            if (ObjectUtil.isNotNull(cookies) && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    if ("authToken".equals(cookie.getName())) {
                        authToken=cookie.getValue();
                        break;
                    }
                }
            }

            if(StrUtil.isNotEmpty(authToken)&&isLogin(authToken,request)){
                return true;
            }

		}

        log.info(" 用户未登录 ip:{}", IPUtils.getIpAddress(request));
        //判断用户是否登录 采用token方式

        String rootPath=request.getRequestURI().replace(request.getServletPath(),"/login");
        response.sendRedirect(rootPath);

		return false;
	}

	/**
	 * 该方法的执行时机是，当某个 URL 已经匹配到对应的 Controller 中的某个方法，
	 * 且在执行完了该方法，但是在 DispatcherServlet 视图渲染之前。所以在这个方法中有个 ModelAndView 参数，可以在此做一些修改动作。
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param o
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 该方法是在整个请求处理完成后（包括视图渲染）执行，这时做一些资源的清理工作，这个方法只有在 preHandle(……) 被成功执行后并且返回 true 才会被执行。
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param o
	 * @param e
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}

    private boolean isLogin(String content,HttpServletRequest request){
        String json= AesUtils.decrypt(ApplicationProperties.USER_LOGIN_AES_KEY_WEB,content);

        if(json==null || "".equals(json)){
            return false;
        }
        MyToken myToken= JSON.parseObject(json,MyToken.class);

        if(myToken!=null && ObjectUtil.isNotNull(myToken.getUserId())){

            request.setAttribute("userId",myToken.getUserId());

            request.setAttribute("userName",myToken.getUserName());

            return true;
        }

        return  false;
    }
}
