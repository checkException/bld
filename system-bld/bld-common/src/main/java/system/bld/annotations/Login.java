package system.bld.annotations;

import system.bld.enums.LoginEnum;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 * 登录校验方式
 * 自定义注解
 * @Author: LiTao
 * @Date: 2020/4/8
 * @Time: 19:21
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {

	/**
	 * 登录校验方式
	 * @return
	 */
	LoginEnum login() default LoginEnum.Skip;

}
