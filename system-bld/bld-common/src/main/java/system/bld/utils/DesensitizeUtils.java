package system.bld.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author litao
 * @date 2021-07-12
 * @Desc
 */
public class DesensitizeUtils {

    // 字符串脱敏
    public static String stringDesensitize(int start,int end,String mobile) {

        String regex="(?<=.{" + start + "}).(?=.{" + end + "})";

        return mobile.replaceAll(regex, "*");
    }

    public static void main(String[] args) {

        System.out.println(stringDesensitize(1,1,"341226199012165211"));
    }
}
