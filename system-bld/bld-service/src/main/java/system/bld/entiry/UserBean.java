package system.bld.entiry;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/4/30
 * @Time: 9:24
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UserBean {

	private String name;

	private Integer age;

	public UserBean(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args) {
		UserBean userBean=new UserBean("sungang",27);

		try {
			Field field= userBean.getClass().getDeclaredField("name");
			boolean accessFlag = field.isAccessible();
			System.out.println(accessFlag);
			field.setAccessible(true);
			Object o=field.get(userBean);
			System.out.println("--------------".concat(o.toString()));
			field.setAccessible(accessFlag);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
