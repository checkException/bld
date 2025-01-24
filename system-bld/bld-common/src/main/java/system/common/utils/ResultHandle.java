package system.common.utils;

import org.apache.commons.collections4.MapUtils;
import system.bld.enums.ErrorCodeEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author litao
 * @date 2021-06-18
 * @Desc
 */
public class ResultHandle {

    private static final String RESPONSE_CODE = "responseCode";
    private static final String RESPONSE_MSG = "responseMsg";

    public ResultHandle() {
    }

    public static boolean isSuccess(Map<String, Object> result) {
        return "0000".equals(MapUtils.getString(result, "responseCode"));
    }

    public static Map<String, Object> success() {
        Map<String, Object> result = new HashMap();
        result.put("responseCode", "0000");
        result.put("responseMsg", "success");
        return result;
    }

    public static Map<String, Object> fail(ErrorCodeEnum errorCodeEnum) {
        return fail(new HashMap(), errorCodeEnum);
    }

    public static Map<String, Object> fail(Map<String, Object> result, ErrorCodeEnum errorCodeEnum) {
        result.put("responseCode", errorCodeEnum.getResponseCode());
        result.put("responseMsg", errorCodeEnum.getResponseMsg());
        return result;
    }
}
