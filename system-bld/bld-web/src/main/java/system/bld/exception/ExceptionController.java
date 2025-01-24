package system.bld.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import system.bld.annotations.Login;
import system.bld.enums.LoginEnum;
import system.bld.response.APIResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * 全局异常捕获类
 * @Author: LiTao
 * @Date: 2020/5/6
 * @Time: 20:06
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Controller
@RequestMapping(value = "/error")
@EnableConfigurationProperties({ServerProperties.class})
public class ExceptionController implements ErrorController {

	private ErrorAttributes errorAttributes;

	@Autowired
	private ServerProperties serverProperties;


	/**
	 * 初始化
	 * @param errorAttributes
	 */
	public ExceptionController(ErrorAttributes errorAttributes) {
		Assert.notNull(errorAttributes, "ErrorAttributes must not be null");

		this.errorAttributes = errorAttributes;
	}

	/**
	 * api 异常 时
	 * @param request
	 * @return
	 */
    @Login(login= LoginEnum.Skip)
	@RequestMapping(value = "")
	@ResponseBody
	public APIResponse error(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.ALL));

		//HttpStatus status = getStatus(request);
		return new APIResponse(APIResponse.FAIL, null, body.get("message").toString());

	}

	/**
	 * 定义异常应该返回的页面ModelAndView
	 * @param request
	 * @param response
	 * @return
	 */
    @Login(login= LoginEnum.Skip)
	@RequestMapping(produces = "text/html",value = "")
	public ModelAndView errorHtml500(HttpServletRequest request,
									 HttpServletResponse response) {
		response.setStatus(getStatus(request).value());
		Map<String, Object> model = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.TEXT_HTML));
		return new ModelAndView("error/500", model);
	}

	/**
	 * Determine if the stacktrace attribute should be included.
	 * @param request the source request
	 * @param produces the media type produced (or {@code MediaType.ALL})
	 * @return if the stacktrace attribute should be included
	 */
	protected boolean isIncludeStackTrace(HttpServletRequest request,
										  MediaType produces) {
		ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
		if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
			return true;
		}
		if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
			return getTraceParameter(request);
		}
		return false;
	}


	/**
	 * 获取错误的信息
	 * @param request
	 * @param includeStackTrace
	 * @return
	 */
	private Map<String, Object> getErrorAttributes(HttpServletRequest request,
												   boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(requestAttributes,
				includeStackTrace);
	}

	/**
	 * 是否包含trace
	 * @param request
	 * @return
	 */
	private boolean getTraceParameter(HttpServletRequest request) {
		String parameter = request.getParameter("trace");
		if (parameter == null) {
			return false;
		}
		return !"false".equals(parameter.toLowerCase());
	}



	/**
	 * 获取错误编码
	 * @param request
	 * @return
	 */
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request
				.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		}
		catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

	/**
	 * Returns the path of the error page.
	 * 实现错误路径,暂时无用
	 * @return the error path
	 */
	@Override
	public String getErrorPath() {
		return null;
	}
}
