package system.bld.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.math.MathUtil;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author litao
 * @date 2024-12-11
 * @Desc 
 */
public class test02 {


    public static void main(String[] args){

        try {
            System.out.println(URLEncoder.encode("哈哈","utf-8"));;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        /*List<Long> alist = Arrays.asList(1131753089L,1129904112L,1130213508L);
        List<Long> blist = Arrays.asList(1129904112L,1130213508L);
        List<Long> resGoodsList = alist.stream().filter(aueryRes -> !blist.contains(aueryRes)).collect(Collectors.toList());
        System.out.println(resGoodsList);

        System.out.println(DateUtil.formatDate(DateUtil.offsetDay(new Date(), -1)));*/
        /*
        Calendar calendar = Calendar.getInstance();

        System.out.println(DateUtil.format(calendar.getTime(),"yyyy-MM-dd HH:mm:ss:SSS"));
        int minuteNum = calendar.get(Calendar.MINUTE);
        int secondNum = calendar.get(Calendar.SECOND);
        System.out.println(minuteNum);
        System.out.println(secondNum);

        System.out.println("分钟取余："+minuteNum%5);
        System.out.println("秒取整："+secondNum/5);
        System.out.println("秒取余："+secondNum%5);

        Map<String,Object> map = new HashMap<>();
        Map<String,Object> map1 = null;
        System.out.println(MapUtils.isEmpty(map));
        System.out.println(MapUtils.isEmpty(map1));
*/

        /*Map<String,Dict> testMap =new HashMap<>();

        testMap.put("A", Dict.create().set("abc","123"));
        testMap.put("B", Dict.create().set("abc","456"));
        testMap.put("C", Dict.create().set("abc","789"));
        testMap.forEach((key,dict) -> {
            dict.set("add","temp");
        });

        for (Map.Entry<String,Dict> entry:testMap.entrySet()){
            System.out.println(JSON.toJSONString(entry));
        }
*/
//        for(int i = 0; i <= 100; i++) {
//            System.out.println(RandomUtil.randomInt(100));
//
//        }
    }
}
