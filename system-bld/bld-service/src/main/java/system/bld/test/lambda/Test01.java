package system.bld.test.lambda;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.http.client.utils.DateUtils;
import system.bld.test.bean.GoodsGameDiscounts;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

/**
 * @author litao
 * @date 2023-03-29
 * @Desc
 */
public class Test01 {

    public static void main(String[] args) {

        System.out.println(new BigDecimal(0).divide(new BigDecimal(1)));
        System.out.println(DateUtil.beginOfDay(DateUtil.yesterday()));

//        String url = "https://jslbwlkjgfyxgs.cdn.qiyukf.net/MTY3NDQzODE=/bmltYV8xODUyMDU4NDA0MV8xNzM1Mjc4OTY1MzQzXzEyNDZhZDNiLTg4ZDQtNDEwOS1iY2Q0LWQ5OTNkNDA1ZjhiYw==?createTime=1735278963287";

        String url = "https://nim-nosdn.netease.im/MTY3NDQzODE=/bmltYV8yNzU2NjIzMTE5OTJfMTczNTA0MDY4NDY1NV85ZjI4NTM0MC01YTVkLTQwZWEtOGUzMS01NTk4ZDg5OTA2YTI=";

        String contentType =HttpRequest.head(url).execute().header("Content-Type");
        System.out.println(contentType);

//        List<Integer> userId = Lists.newArrayList(1005046,1005045,1005047,1005048,1005049,1005010,1005011);
        List<Integer> userId = Lists.newArrayList();
        String accountUserId = Joiner.on("/").join(userId);
        System.out.println(accountUserId);
//        String accountUserIdStr=  accountUserId.substring(0,30);
//        System.out.println(accountUserIdStr);
//        System.out.println(accountUserIdStr.substring(0,accountUserIdStr.lastIndexOf("/")));;

        String comparisonValue= "123123123_1_1";
        String partialComparisonValue= "123123123_1_1";
        System.out.println(StrUtil.equals(comparisonValue,partialComparisonValue));
       /* System.out.println("abf满园清香为你而开;是吗？你瞎说:的吧;哈哈；aaa");
        System.out.println("abf满园清香为你而开;是吗？你瞎说:的吧;哈哈；aaa".replaceAll(";","；"));*/
        /*System.out.println(String.format("百分比加价设置校验上限不能超过[%s] 阿萨德s%", 300));

        System.out.println("123456789\n".length());
        System.out.println("123456789\n".trim().length());*/
        /*for(int i = 0; i < 20; i++) {
            System.out.println(new BigDecimal(20*Math.random()).setScale(2, BigDecimal.ROUND_UP).toString());
        }*/
       /* System.out.println(null == Integer.valueOf(1));
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0,0);

        System.out.println(JSON.toJSONString(list));
*/
        /*Integer a = null;
        System.out.println(a.intValue());

        String today = DateUtil.format(new Date(), "yyyy-MM-dd");

        Date tenClock = DateUtil.parse(today+" 10:00:00");

        System.out.println(tenClock);*/

//        System.out.println(11%12);
//        System.out.println((new BigDecimal(11)).divide(new BigDecimal(12),2, BigDecimal.ROUND_DOWN).compareTo(new BigDecimal("0.9")));
//        System.out.println((new BigDecimal(11).divide(new BigDecimal(12))).compareTo(new BigDecimal("0.9")));
    }

    public static void method3(){
        int i=100;
        i=i++;
        System.out.println(i);//100
        System.out.println(i=i++);//100

    }
}
