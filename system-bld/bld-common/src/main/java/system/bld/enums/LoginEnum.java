package system.bld.enums;

/**
 * Created with IntelliJ IDEA.
 * 登录注解枚举
 * @Author: LiTao
 * @Date: 2020/4/8
 * @Time: 15:54
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public enum LoginEnum {

	/** 正常（默认） */
	Normal("0", "执行权限验证"),

	/** 跳过 */
	Skip("1", "跳过权限验证");

	/** 主键 */
	private final String key;

	/** 描述 */
	private final String desc;

	LoginEnum(final String key, final String desc) {
		this.key = key;
		this.desc = desc;
	}

	public String getKey() {
		return key;
	}

	public String getDesc() {
		return desc;
	}
}
