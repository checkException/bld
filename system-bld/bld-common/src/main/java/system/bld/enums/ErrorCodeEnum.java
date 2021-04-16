package system.bld.enums;


/**
 * 
 * @author Administrator
 *
 */
public enum ErrorCodeEnum {

    /**
     * 请先实名认证
     */
    NO_REAL_AUTH("2109", "请先实名认证"),
    
    /**
     * 用户被冻结
     */
    USER_FROZEN("9995","用户被冻结"),
    /**
     * 用户未登录
     */
    NOT_LOGIN("9996","用户未登录"),
	/**
     * 查询结果为空
     */
    QUERY_NO_RESULT("9997","查询结果为空"),
    /**
     * 参数非法
     */
    ILLEGAL_ARGUMENT("9998","参数非法"),

    /**
     * 成功
     */
    SUCCESS("0000","success"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR("9999","当前网络忙，请稍后再试"),

    /**
     * 10分钟内 重复提交反馈
     */
    OPERATE_MORE("7914","操作频繁，请稍后再试");

	 /**
     * 响应码
     */ 
	private String responseCode;
    /**
     * 描述
     */
    private String responseMsg;
    /**
     * 私有构造函数
     * 
     * @param responseCode
     * @param responseMsg
     */
    private ErrorCodeEnum(String responseCode, String responseMsg) {
        this.responseCode = responseCode;
        this.responseMsg = responseMsg;
    }

	public String getResponseCode() {
		return responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}
	

}
