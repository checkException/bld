package system.bld.entiry;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/3/20
 * @Time: 14:45
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UserEntity {

	private Integer id;

	private String openId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	@Override
	public String toString() {
		return "id:".concat(String.valueOf(id)).concat(",openId").concat(openId);
	}
}
