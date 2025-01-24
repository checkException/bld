package system.bld.service;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Dict;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.*;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.dfa.WordTree;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.kisso.common.util.Base64Util;
import com.google.common.base.Joiner;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import system.bld.model.UserBase;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/6/10
 * @Time: 16:25
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class TestMain {
    private static final Pattern areaServerPatternr = Pattern.compile("^(安Q|果Q|安V|果V)\\d{1,3}区$");
    private static final Pattern sytPatternr = Pattern.compile("^('member'|'common')$");

	public static void main(String[] args)  {

        List<Integer> sourceList = Arrays.asList(2,3);
        System.out.println(sourceList.contains(null));
       /* String key = "小牛肉";
        int h;
        *//*System.out.println( (h = key.hashCode()));
        System.out.println(h >>> 16);
        System.out.println(23588317 ^ 359);
*//*
	    String str =null;
        System.out.println("1".equals(str));
        System.out.println(str.equals("1"));*/
/*
        try {
            System.out.println(Base64Util.encode(String.valueOf(10032101).getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(SecureUtil.aes().encryptBase64(String.valueOf(10032101)));
        System.out.println(SecureUtil.md5().digestHex16(String.valueOf(100321000)));
        System.out.println(SecureUtil.md5().digestHex(String.valueOf(100321000)));*/

	    /*List<Long> list = JSON.parseArray("[27244378,27244390,27244391,27244419,27244427,27244442,27244453,27244457,27244460,27244463,27244468,27244477" +
                ",27244482,27244483,27244489,27244494,27244511,27244517," +
                "27244529,27244556,27244561,27244582,27244588,27244605,27244607,27244622,27244624,27244631,27244638,27244641,27244651,27244675,27244677,27244679," +
                "27244688,27244690,27244697,27244703,27244711,27244713,27244717,27244729,27244731,27244733,27244752,27244759,27244763,27244768,27244774,27244776," +
                "27244777,27244782,27244784,27244789,27244790,27244794,27244799,27244823,27244826,27244827,27244836,27244840,27244841,27244843,27244860,27244876," +
                "27244879,27244893,27244898,27244900,27244924,27244927,27244944,27244950,27244955,27244962,27244963,27244969,27244998,27245000,27245002,27245010," +
                "27245014,27245051,27245057,27245069,27245073,27245077,27245082,27245088,27245091,27245108,27245115,27245151,27245177,27245191,27245211,27245227,27245228," +
                "27245238,27245245,27245246,27245249,27245251,27245256,27245260,27245296,27245299,27245310,27245311,27245313,27245338,27245362,27245365,27245380,27245385," +
                "27245388,27245393,27245412,27245420,27245421,27245428,27245432,27245435,27245438,27245440,27245444,27245450,27245451,27245455,27245457,27245458,27245465," +
                "27245476,27245477,27245482,27245487,27245488,27245498,27245501,27245505,27245506,27245507,27245511,27245549,27245575,27245583,27245585,27245599,27245642,27245643,27245647,27245655,27245658,27245662,27245665,27245686,27245704,27245705,27245709,27245716,27245720,27245723,27245725,27245741," +
                "27245742,27245746,27245750,27245754,27245755,27245770,27245771,27245775,27245795,27245796,27245797,27245804,27245806,27245813,27245821,27245830,27245837,27245848," +
                "27245854,27245886,27245893,27245897,27245909,27245914,27245926,27245946,27245948,27245950,27245953, 27245958,27245960,27245966,27245967,27245991,27246014]"
                ,Long.class);

	    Long userId = null;

        for (int i = 0; i < 5; i++) {

        }

        for (int i = 0; i < 10; i++) {
            userId = list.get(list.size() - 2);
            list.remove(list.size() -1);
            System.out.println(userId);
        }

        System.out.println( DateUtil.thisDayOfWeek());*/
       /* Map<String,Object> orderCompleteRedPackMap = new HashMap<>();
        //orderCompleteRedPackMap.put("clientType",10);
        System.out.println(MapUtil.getBool(orderCompleteRedPackMap,"selfGoods"));
        System.out.println(!orderCompleteRedPackMap.containsKey("clientType") || MapUtil.getInt(orderCompleteRedPackMap,"clientType")!=10);*/
//        if(MapUtil.getBool(orderCompleteRedPackMap,"selfGoods")){
//
//            System.out.println(1111111111);
//        }
       /* System.out.println(DateUtil.offsetDay(new Date(),30).getTime());
        System.out.println(Long.valueOf("1702275803967")-Long.valueOf("86400000"));
        System.out.println(NumberUtil.div(435759,1279224));
        System.out.println(String.valueOf(NumberUtil.decimalFormat("#.##%",435759/1279224)));
        List<String> gameIdList =JSON.parseArray("[\"SMZHSY001\",\"AQTW001\",\"A4869\"]",String.class);
        System.out.println();
        System.out.println(DateUtil.yesterday());*/
//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.SECOND, 999999999*86400);
//        System.out.println(DateUtil.format(c.getTime(), "yyyy-MM-dd HH:mm:ss"));
//        System.out.println(DateUtil.parse("2022-11-08 00:00:00"));
//        System.out.println(DateUtil.betweenDay(new Date(), DateUtil.parseDate("2022-11-11 14:20:00"), true));
/*
	    String sss ="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJVqvedhg7VR0+uaCjny2LoZy46CR6xwunmpc2GBZttKOE+siibM4RBaOfK8e5/BkTt7a0vGm28hZj/UX4ETaM/EA4TZwSokpFaYvmPOdD9yXueJIl1Zs68fsT4s6sO4Fg9EaryA7HJ+TtZfSOP2PrCkz6DfSn7dGUtzou+Q+z13AgMBAAECgYAszn62VUrO5AP+AgqRCB8v565gRPdDYea5tzPviIOUvTQXyHEBY60WX0hDX3xfEwf/Y2pwpdVUxRpJh+E/7tceCV+ZJD9R1c2vOIlQdV4NzI0LeqIs0WpZhBkZ6NVJ3CqT3hABeZZcgv5wdpx2+McGokIoE8EN2kLYdInKHi+IwQJBANGjSeS/dH60Hqa3fHxOD766s4ZE3ZqulASQImrzbjWUsv/+cQaBUFI6lwKqY9IUOqO42eSEqkFx1odAChdKJqECQQC2dgd0Sm7CVAlV4+3JMzx47BfhFI3VJiCwNDEBAmj9omgtf7j+OxD10DuYvC3hAPsWUvdOpT6cCSsgR1nS7KUXAkA1XXbTBzW1h06CLBVBY3G4oLhQhrlOxgAiBTrttNgqRZcneXL2L/btZ8LHR+6vLL0crlKxTGA21q7AsTmgYhzhAkBuquwehr7jMyFubQ7eyCrXlStuo47bR4LwHNfUKugPXqAdaKiF2sGQtrpPC2QwYu3oPm4tz2BIN+9mZqB+pHYFAkEAjcvlOtvoa1EwOOvRvHStERqiAYFEKxb47oM/RYr+B205Of0S2j2glEdAIjv8QYAUXNkK8kbqIPdJ7ohnJvWabw==";

        System.out.println();
        System.out.println(DateUtil.today());

        List<String> list = Arrays.asList("//picture.uhaozu.com/2019/31/30/ad7066a4f34d4930a75f77c137b5a3d1.jpg","//picture.uhaozu.com/2019/31/30/ad7066a4f34d4930a75f77c137b5a3d1.jpg","//picture.uhaozu.com/2019/31/30/ad7066a4f34d4930a75f77c137b5a3d1.jpg");
        System.out.println(list.toString());
        System.out.println(JSON.toJSONString(list));*/
        /*Pattern vipPatternnteger = Pattern.compile("[0-9]|([1][0-9]|[2][0])");
        Matcher matcher = vipPatternnteger.matcher("9");
        System.out.println(matcher.matches());

        System.out.println(Arrays.asList("1","2").contains(null));
*/

        Date startTime = DateUtil.parse(DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MINUTE_PATTERN).concat(":00"));

//		params.put("startTime",startTime);

        Date endTime = DateUtil.offsetMinute(startTime,1);

        System.out.println(endTime);
        /*System.out.println(Integer.valueOf(1).equals(null));
        Integer integer = null;
        System.out.println(integer.equals(Integer.valueOf(1)));
        System.out.println(System.currentTimeMillis());
        System.out.println(DateUtil.currentSeconds());
*/
        /*String loginPassword ="b7725febfcfd42aaa1fecdc5ac3a8a00";
        System.out.println(loginPassword.length());

        if(StringUtils.isNotBlank(loginPassword)&&loginPassword.length()>32){

            System.out.println(123);
        }*/

        /*HttpResponse response = HttpRequest.head("http://ftpzuhao.17of.com/reconciliation/reconciliation-2022-06-211.xlsx").execute();
        int status = response.getStatus();
        System.out.printf("111:"+status);*/

	    /*int [] array=new int[]{15,16,17,21,3,5,10,15};

	    int min =array[0];
	    int count = 7;
        for (int i = 0; i < array.length; i++) {

            if(array[i]<=min&&array[i]>count){
                min = array[i];
            }

        }*/

       // System.out.println("min value :".concat(String.valueOf(min)));

	    /*String rentTimeLimitStr ="member";
        //Matcher matcher = areaServerPatternr.matcher(rentTimeLimitStr);
        Matcher matcher = sytPatternr.matcher(rentTimeLimitStr);
        System.out.println(matcher.matches());*/

	    /*String privateKey ="{\"startTime\":\"2022-04-12 10:00:00\"}";
        Map<String, Object> confMap = JSONObject.parseObject(privateKey, new TypeReference<Map<String, Object>>() {
        });

        System.out.println(MapUtil.isEmpty(confMap));*/

	    /*Map<Integer, Object> map =new HashMap();
	    map.put(7,"7");
	    map.put(5,"5");
	    map.put(1,"1");
	    map.put(4,"4");
	    map.put(3,"6");
	    map.put(11,"11");
	    map.put(19,"19");

	    Map<Integer, Object> map1 =new TreeMap();
	    map1.putAll(map);

	    Date dd=DateUtil.parse("2022-04-25 20:26:35");
        System.out.println(dd.after(new Date()));
        //System.out.println(JSON.toJSONString(map1));

        for (Map.Entry<Integer, Object> entry:map1.entrySet()) {

            System.out.println(entry.getKey());

        }*/
        /*Integer a = new Integer(3);
        Integer b = 3;
        int c=3;
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(a .equals( b));*/

	   /* int a = 0;
	    int b = 1;
        System.out.println((a=b)+1);
        System.out.println(a);*/
        /*Set<String> setStr = new HashSet<>();

	    setStr.add("1234567890");*/

/*
	    String str="1asd12";

        System.out.println(str.substring(0,3).concat("***").concat(str.substring(3,6)));

        System.out.println(Joiner.on("$").join(1005046,0,"123456789","litao123"));
        System.out.println(DateUtil.offsetDay(new Date(),0));
        System.out.println(valiDateTimeWithLongFormat("2021-11-22 13:34:26"));
        System.out.println(valiDateTimeWithLongFormat("2021-11-221 13:34:26"));
        System.out.println(valiDateTimeWithLongFormatYYYY_MM_DD("2021-11-31"));
*/

        //strArr();
        /*System.out.println("123XX".equalsIgnoreCase("123xx"));
        System.out.println("123XX".equals("123xx"));
        System.out.println(Integer.valueOf(123).doubleValue()/100);

        Date yesterday=DateUtil.parse(DateUtil.offsetDay(DateUtil.parse("2022-04-25 19:26:35"),-1).toDateStr(),"yyyy-MM-dd");
        Date dateDay=DateUtil.parse("2021-09-01");
        Long betweenDay= DateUtil.betweenDay(dateDay,yesterday,true);
        int endDay=betweenDay.intValue()+1;
        System.out.println(endDay);
        System.out.println(betweenDay.intValue());
        System.out.println(DateUtil.offsetDay(dateDay,betweenDay.intValue()));
        System.out.println(DateUtil.offsetDay(dateDay,endDay));
        System.out.println(DateUtil.offsetDay(new Date(),-31).toDateStr());*/
    }

    /**
     * 验证时间字符串格式输入是否正确
     * @param timeStr
     * @return
     */
    public static boolean valiDateTimeWithLongFormat(String timeStr) {
        String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) "
                + "([01]?[0-9]|2[0-3]):[0-5]?[0-9]:[0-5]?[0-9]";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(timeStr);
        if (matcher.matches()) {
            /*pattern = Pattern.compile("(\\d{4})-(\\d+)-(\\d+).*");
            matcher = pattern.matcher(timeStr);
            if (matcher.matches()) {
                int y = Integer.valueOf(matcher.group(1));
                int m = Integer.valueOf(matcher.group(2));
                int d = Integer.valueOf(matcher.group(3));
                if (d > 28) {
                    Calendar c = Calendar.getInstance();
                    c.set(y, m-1, 1);
                    int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
                    return (lastDay >= d);
                }
            }*/
            return true;
        }
        return false;
    }

    public static boolean valiDateTimeWithLongFormatYYYY_MM_DD(String timeStr) {
        String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(timeStr);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    public static void strArr(){
	    String dayOfWeek="[\"00:00-08:00\",\"08:00-09:00\",\"09:00-11:00\"]";
        List<String> timeArr= JSONObject.parseArray(dayOfWeek,String.class);
        for (int i = 0; i < timeArr.size(); i++) {
            System.out.println(timeArr.get(i));
        }
    }

	/**
	 * 时间格式测试
	 */
	public static void dateTest(){
		System.out.println(DateUtil.parse(DateUtil.format(new Date(), DatePattern.NORM_DATE_PATTERN).concat(" 17:00:00")).compareTo(new Date()));

		System.out.println(DateUtil.parse(DateUtil.format(new Date(), DatePattern.NORM_DATE_PATTERN).concat(" 23:59:59")));
		System.out.println(DateUtil.offsetDay(new Date(),1));

		System.out.println(DateUtil.beginOfDay(new Date()));
		System.out.println(DateUtil.endOfDay(new Date()));

		System.out.println(490/100);

		System.out.println(DateUtil.betweenDay(new Date(), DateUtil.parse("2020-07-03 23:59:59"), false));
		System.out.println(DateUtil.between(new Date(), DateUtil.parse("2020-07-03 23:59:59"), DateUnit.DAY));

		System.out.println(DateUtil.parse("2020-07","yyyy-MM"));
		System.out.println(DateUtil.parse(DateUtil.offsetDay(new Date(),-1).toDateStr(),"yyyyy-MM-dd"));
	}

	/**
	 * dfa算法 关键字过滤
	 */
	public static void keyWordMacth(){
		String text="中华人民共和国（People's Republic of China），简称“中国”，成立于1949年10月1日 [1] " +
				" ，位于亚洲东部，太平洋西岸 [2]  ，" +
				"是工人阶级领导的、以工农联盟为基础的人民民主专政的社会主义国家 [3]  ，" +
				"以五星红旗为国旗 [4]  、《义勇军进行曲》为国歌 [5]  ，国徽内容为国旗、天安门、齿轮和麦稻穗 [6]  ，" +
				"通用语言文字是普通话和规范汉字 [7]  ，首都北京 [8]  ，" +
				"是一个以汉族为主体、56个民族共同组成的统一的多民族国家。";

		text.concat("litao").concat("|uhaozu");
		List<String> wordsList=new ArrayList<>();
		wordsList.addAll( Arrays.asList(new String[]{"中华人民","中国","工人阶级","人民民主专政","社会主义","统一","汉字","民族"}));

		List<String> lists=new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			lists.add(RandomUtil.randomString("abcdefghijklmnopqrstuvwsyz",5));
		}

		wordsList.addAll(lists);
		WordTree tree=new WordTree();
		tree.addWords(wordsList);

		//匹配所有并且列出关键字
		List<String> matchAll = tree.matchAll(text, -1, false, false);
		//只匹配第一个关键字
		String word=tree.match(text);

		//是否含有关键字
		boolean result=tree.isMatch(text);

		System.out.println(matchAll);

		System.out.println(word);

		System.out.println(result);

	}

	public static void integerTest(){
		Integer aa=1000;
		Integer bb=1111;
		Integer cc=aa+bb;

		System.out.println((double)aa/100);
		System.out.println((double)bb/100);
		System.out.println((double)cc/100);

		System.out.println(new BigDecimal(aa).divide(new BigDecimal(100)));
		System.out.println(new BigDecimal(cc).divide(new BigDecimal(100)));
	}


	public static void subStrTest(){

	    List<Map<String,String>> list=new ArrayList<>();

        Map<String,String> map1=new HashMap<>();
        map1.put("referres","发现虚拟环境(a-c0fc0acbf82258c694a79f3034aa618b) 已拦截");
        list.add(map1);

        Map<String,String> map2=new HashMap<>();
        map2.put("referres","发现调试模式(isVA-notHook-notDebug)(a-198549f5d50e0b14a31e999d48f14786) 已拦截");
        list.add(map2);

        Map<String,String> map3=new HashMap<>();
        map3.put("referres","发现游戏签名异常(a-8a024de97c72375593b7fc6fd219d348) 已拦截");
        list.add(map3);


        for (Map<String,String> response:list) {

            //
            String referres= response.get("referres");

            if(referres.startsWith("发现")){

                if(referres.startsWith("发现恶意用户")){
                    continue;
                }else if(referres.startsWith("发现调试模式")){

                    if(referres.endsWith("已拦截")){
                        String newReferres= referres.substring(referres.indexOf(")")+1);

                        response.put("referres","发现风险环境".concat(newReferres));
                    }else{
                        String newReferres= referres.substring(referres.indexOf(")")+1);

                        response.put("referres","发现风险环境 已拦截".concat(newReferres));
                    }


                }else{
                    if(referres.endsWith("已拦截")){
                        String newReferres= referres.substring(referres.indexOf("("));
                        response.put("referres","发现风险环境".concat(newReferres));
                    }else{
                        String newReferres= referres.substring(referres.indexOf("("));
                        response.put("referres","发现风险环境 已拦截".concat(newReferres));
                    }

                }
            }

        }

        for (Map<String,String> response:list) {
            System.out.println(response.get("referres"));
        }
    }

}
