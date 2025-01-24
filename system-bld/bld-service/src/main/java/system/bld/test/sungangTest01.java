package system.bld.test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author litao
 * @date 2024-01-05
 * @Desc
 */
public class sungangTest01 {

//    private static final Pattern areaServerPatternr = Pattern.compile("^(concat|split|replace)\\((.*)\\)+$");
    private static final Pattern areaServerPatternr = Pattern.compile("^(.*)+\\((.*)\\)$");
    private static final Pattern ddd = Pattern.compile("\\((.*)\\)");

    public static void main(String[] args) {
        String string ="concat('abc',temp,'efg')";
        String string1 ="split('123456,123,123,123')";
        String replace ="replace('dasdad123','123')";

        analysis(string);
        System.out.println("------------------");
        analysis(string1);
        System.out.println("------------------");
        analysis(replace);
    }
    public static void analysis(String params){
        Matcher matcher = areaServerPatternr.matcher(params);

        if(matcher.matches()){
            String method = matcher.group(1);
            String paramStrArray = matcher.group(2);
            List<String> paramList = Arrays.asList(paramStrArray.split(","));

            System.out.println("方法是：".concat(params.substring(0,params.indexOf("("))));

            String out = "参数%S:%s";
            for (int i = 0; i < paramList.size(); i++) {
                System.out.println(String.format(out, String.valueOf(i),paramList.get(i)));
            }


        }
    }
}
