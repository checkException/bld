package system.bld.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPUtils {
    
	/**
	 * 获取真实IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddress(HttpServletRequest request) {

		String ipAddress = null;
		
		ipAddress = getIpByHeaderName(request, "x-forwarded-for");
		if (StringUtils.isBlank(ipAddress)) {
		    
			ipAddress = request.getHeader("Proxy-Client-IP");
			
			if (StringUtils.isBlank(ipAddress)) {
                
			    ipAddress = getIpByHeaderName(request, "WL-Proxy-Client-IP");
			    
			    
			    if (StringUtils.isBlank(ipAddress)) {
			        
			        ipAddress = request.getRemoteAddr();
			        
			        if (ipAddress.equals("127.0.0.1")|| "0:0:0:0:0:0:0:1".equals(ipAddress)) {
		                return "127.0.0.1";
		            }
                    
                }
            }
		}
		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (StringUtils.isNotBlank(ipAddress)&& ipAddress.length() > 15) {
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = StringUtils.substringBefore(ipAddress, ",");
			}
		}
		return ipAddress;
	}
	
	
	public static String getIpByHeaderName(HttpServletRequest httpServletRequest, String headerName){
	    
	    String ipAddress = httpServletRequest.getHeader(headerName);
	    ipAddress = (StringUtils.isBlank(ipAddress) || "unknown".equalsIgnoreCase(ipAddress))?null:ipAddress;
	    
	    return ipAddress;
	}
	
	
	/**
	 * 检查是否内网IP地址
	 * @param ip
	 * @return
	 */
	public static boolean isInnerIpAddress(String ipAddress){
	    
	    if ("127.0.0.1".equals(ipAddress)) {
            
	        return true;
        }
	    String reg = "(^10|172|192)\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})\\.([0-1][0-9]{0,2}|[2][0-5]{0,2}|[3-9][0-9]{0,1})";//正则表达式=。 =、懒得做文字处理了、
	    Pattern p = Pattern.compile(reg);
	    Matcher matcher = p.matcher(ipAddress);
	    return matcher.find();
	}
	
	/**
	 * 获取本机的IP得知
	 * @return
	 */
	public static String getLocalIpAddress(){
	    
	    try{  
	        
            return InetAddress.getLocalHost().getHostAddress().toString();//获得本机IP　
            
        }catch(Exception e){  
            
            return null;
        }  
	}
}
