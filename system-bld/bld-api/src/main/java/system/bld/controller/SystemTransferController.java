package system.bld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import system.bld.annotations.Login;
import system.bld.enums.ErrorCodeEnum;
import system.bld.enums.LoginEnum;
import system.bld.response.APIResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author litao
 * @date 2021-06-22
 * @Desc
 */
@RestController
@RequestMapping("/error/transfer")
public class SystemTransferController extends BaseApiController {
    private static final Logger log= LoggerFactory.getLogger(SystemTransferController.class);

    @Login(login= LoginEnum.Skip)
    @RequestMapping("")
    public APIResponse errorMethod(HttpServletRequest request, HttpServletResponse response){

        ErrorCodeEnum errorCodeEnum= (ErrorCodeEnum)request.getAttribute("errorCodeEnum");
        APIResponse apiResponse=new APIResponse();

        apiResponse.setCode(Integer.valueOf(errorCodeEnum.getResponseCode()));
        apiResponse.setMsg(errorCodeEnum.getResponseMsg());

        return apiResponse;
    }
}
