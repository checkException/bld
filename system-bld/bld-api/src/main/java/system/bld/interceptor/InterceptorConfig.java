package system.bld.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created with IntelliJ IDEA.
 * 自定义拦截器配置类
 * @Author: LiTao
 * @Date: 2020/3/26
 * @Time: 10:06
 * To change this template use File | Settings | File Templates.
 * Description:
 */
//@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

	/**
	 * 默认不拦截/resources/static目录下的资源文件
	 * @param registry
	 */
	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//addPathPatterns 拦截路径
		//excludePathPatterns 不拦截路径
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/500","/404","/error");
        //registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
	}*/

}
