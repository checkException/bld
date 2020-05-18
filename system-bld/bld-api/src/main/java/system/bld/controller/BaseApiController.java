package system.bld.controller;

import system.bld.response.APIResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/5/12
 * @Time: 9:48
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class BaseApiController {

	protected APIResponse sucess(Object o){

		return new APIResponse(200,"请求成功",o);
	}
}
