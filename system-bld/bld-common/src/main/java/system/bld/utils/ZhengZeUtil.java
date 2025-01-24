package system.bld.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author litao
 * @date 2022-04-18
 * @Desc 正则表达式 方法
 */
public class ZhengZeUtil {

    private  static Pattern pattern = Pattern.compile("^[1-9]\\d{0,8}(\\.\\d{1,2})?$|^0(\\.\\d{1,2})?$");
    private static Pattern depositPattern = Pattern.compile("^[0-9]\\d{0,8}$");

    private static boolean isNumber(String value){

        Matcher matcher = depositPattern.matcher(value);
        if (matcher.matches() == false){
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isNumber("0.123"));
        System.out.println(isNumber("37.12"));
        System.out.println(isNumber("7.12"));
        System.out.println(isNumber("127.12"));
        System.out.println(isNumber("0"));
        System.out.println(isNumber("10"));
        System.out.println(isNumber("101"));
        System.out.println(isNumber("10111111"));
        System.out.println(isNumber("101111111"));
    }
}
