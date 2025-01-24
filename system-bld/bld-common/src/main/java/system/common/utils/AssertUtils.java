package system.common.utils;

import org.apache.commons.lang3.StringUtils;
import system.bld.enums.ErrorCodeEnum;
import system.common.exception.AppException;


/**
 * 断言工具类 ,可以减少if else的判断<br>
 * 〈功能详细描述〉
 * 
 * @author 14073698
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class AssertUtils {
    /**
     * 工具类禁止被实例化
     */
    private AssertUtils(){}
    /**
     * 
     * 不能为空断言<br>
     * 〈功能详细描述〉
     *
     * @param str
     * @param ErrorCodeEnum
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void isNotBlank(String str, ErrorCodeEnum ErrorCodeEnum){
        
        if (StringUtils.isBlank(str)) {
            
            throw new AppException(ErrorCodeEnum);
        }
    }
    
    
    /**
     * 断言字符串数组内字符串都不为空
     * @param strArray
     * @param errorCodeEnum
     */
    public static void isAllNotBlank(String[] strArray,ErrorCodeEnum errorCodeEnum){
        
        for (String str : strArray) {
            
            isNotBlank(str, errorCodeEnum);
        }
    }
    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param str
     * @param errorCodeEnum
     * @param msg
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void isNotBlank(String str,ErrorCodeEnum errorCodeEnum,String msg){
        
        if (StringUtils.isBlank(str)) {
            
            throw new AppException(errorCodeEnum,msg);
        }
    }
    
    /**
     * 断言为真
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param bool
     * @param ErrorCodeEnum
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void isTrue(boolean bool,ErrorCodeEnum ErrorCodeEnum){
        
        if (!bool) {
            
            throw new AppException(ErrorCodeEnum);
        }
    }
    
    /**
     * 断言为真
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param bool
     * @param ErrorCodeEnum
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void isTrue(boolean bool,ErrorCodeEnum ErrorCodeEnum,String message){
        
        if (!bool) {
            
            throw new AppException(ErrorCodeEnum,message);
        }
    }


    /**
     * 断言为真
     * 功能描述: <br>
     * 〈功能详细描述〉
     * @param bool
     * @param responseCode
     * @param responseMsg
     */
    public static void isTrue(boolean bool,String responseCode,String responseMsg){
        
        if (!bool) {
            
            throw new AppException(responseCode,responseMsg);
        }
    }
    /**
     * 对象非空断言
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param object
     * @param ErrorCodeEnum
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void isNotNull(Object object, ErrorCodeEnum ErrorCodeEnum){
        
        if (object == null) {
            
            throw new AppException(ErrorCodeEnum);
        }
    }
    
    /**
     * 
     * 对象非空断言
     * 〈功能详细描述〉
     *
     * @param object
     * @param ErrorCodeEnum
     * @param message
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void isNotNull(Object object,ErrorCodeEnum ErrorCodeEnum,String message){
        
        if (object == null) {
            
            throw new AppException(ErrorCodeEnum,message);
        }
    }
}
