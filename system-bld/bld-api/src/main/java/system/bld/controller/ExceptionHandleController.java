package system.bld.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import system.bld.response.APIResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * @author litao
 * @date 2021-06-22
 * @Desc
 */
@ControllerAdvice
public class ExceptionHandleController {
    private static final Logger log= LoggerFactory.getLogger(ExceptionHandleController.class);

    private static String userError="用户未登录";
    /**
     * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public APIResponse exceptionHandler(HttpServletRequest req, Exception e){
        log.error("未知异常！原因是:{}",e);

        if(e.toString().indexOf(userError)>0){

            return new APIResponse(9996,userError,e.getMessage());
        }
        APIResponse apiResponse=new APIResponse();
        apiResponse.setCode(9999);
        apiResponse.setMsg(e.getMessage());
        return apiResponse;
    }
}
