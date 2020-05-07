package system.bld.interceptor;

import cn.hutool.core.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import system.bld.annotations.Login;
import system.bld.enums.LoginEnum;

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
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
		log.info("LoginInterceptor enter ..... ");

		if(handler instanceof HandlerMethod){
			Login login= ((HandlerMethod) handler).getMethodAnnotation(Login.class);

			if(ObjectUtil.isNotNull(login)){
				//免校验 跳过验证
				if(login.login()== LoginEnum.Skip){
					return true;
				}
			}


			//判断用户是否登录 采用token方式
		}


		log.info(" interceptor ....");
		return true;
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
}
