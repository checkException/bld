package system.bld.response;

/**
 * Created with IntelliJ IDEA.
 * 接口结果 bean
 * @Author: LiTao
 * @Date: 2020/5/6
 * @Time: 20:16
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class APIResponse {

	public static Integer SUCESS=200;

	public static Integer FAIL=9999;

	/**
	 * 响应业务状态
	 */
	private Integer code;

	/**
	 * 响应消息
	 */
	private String msg;

	/**
	 * 响应中的数据
	 */
	private Object data;


	public APIResponse fail(){
		return new APIResponse(FAIL,"失败",null);
	}

	public APIResponse fail(Integer code){
		return new APIResponse(code,"失败",null);
	}

	public APIResponse ok(){
		return new APIResponse(SUCESS,"成功",null);
	}

	public APIResponse ok(Integer code){
		return new APIResponse(code,"成功",null);
	}

	public APIResponse(Integer code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public APIResponse setCode(Integer code) {
		this.code = code;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public APIResponse setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public Object getData() {
		return data;
	}

	public APIResponse setData(Object data) {
		this.data = data;
		return this;
	}


}
