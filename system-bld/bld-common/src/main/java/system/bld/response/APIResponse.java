package system.bld.response;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * 接口结果 response
 * @Author: LiTao
 * @Date: 2020/5/6
 * @Time: 20:16
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class APIResponse implements Serializable {

    private static final long serialVersionUID = 2028878921262581399L;
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
        this.code=FAIL;
        this.msg="失败";
        return this;
	}

	public APIResponse fail(Integer code){
	    this.code=code;
	    this.msg="失败";
        return this;
	}

	public APIResponse ok(){
        this.code=SUCESS;
        this.msg="成功";
        return this;
	}

	public APIResponse ok(Integer code){
        this.code=code;
        this.msg="成功";
        return this;
	}

    public boolean isSuccess() {
        return Integer.valueOf(200).equals(this.code);
    }

   /* public static <T> APIResponse<T> success(T data) {
        return new APIResponse(data);
    }*/


    public APIResponse() {
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
