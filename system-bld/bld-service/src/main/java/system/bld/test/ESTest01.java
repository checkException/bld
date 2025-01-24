package system.bld.test;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * @author litao
 * @date 2022-10-27
 * @Desc
 */
public class ESTest01 {

    private static String url ="http://101.132.98.124:9200/";

    public static void main(String[] args) {

//        String indexName ="20221027";
        String indexName ="20221104";

        String id="1001";

        put_es(indexName,id);

//        query_index_all(indexName);
        query_keyWord(indexName,"去日苦多");
    }


    /**
     * 新增
     * @param indexName 索引名词
     * @param id
     */
    private static void put_es(String indexName,String id){
        Map<String,Object> requestData =new HashMap<>();
        requestData.put("name","小黑");
        requestData.put("age","23");
        requestData.put("sex","男");
        requestData.put("mobile","15105695442");
        requestData.put("description","对酒当歌，人生几何！\n" +
                "譬如朝露，去日苦多。\n" +
                "慨当以慷，忧思难忘。\n" +
                "何以解忧？唯有杜康。\n" +
                "青青子衿，悠悠我心。\n" +
                "但为君故，沉吟至今。\n" +
                "呦呦鹿鸣，食野之苹。\n" +
                "我有嘉宾，鼓瑟吹笙。\n" +
                "明明如月，何时可掇？\n" +
                "忧从中来，不可断绝。\n" +
                "越陌度阡，枉用相存。\n" +
                "契阔谈讌，心念旧恩。\n" +
                "月明星稀，乌鹊南飞。\n" +
                "绕树三匝，何枝可依？\n" +
                "山不厌高，海不厌深。\n" +
                "周公吐哺，天下归心");

        put_es(indexName, id,requestData);
    }

    private static void put_es(String indexName,String id,Map<String,Object> requestData){
        HttpResponse httpResponse = HttpUtil.createRequest(Method.PUT, url.concat(indexName)
                .concat("/_doc/" + id)).contentType("application/json; charset=UTF-8")
                .body(JSON.toJSONString(requestData)).timeout(3000).execute();

        String result = httpResponse.body();

        System.out.println(result);
    }

    /**
     * 更新
     * @param indexName  索引名词
     * @param id 表
     * @param requestData 内容
     */
    private static void update_es(String indexName,String id,Map<String,Object> requestData){

        HttpResponse httpResponse = HttpUtil.createRequest(Method.PUT, url.concat(indexName)
                .concat("/_doc/" + id+"/_update")).contentType("application/json; charset=UTF-8")
                .body(JSON.toJSONString(requestData)).timeout(3000).execute();

        String result = httpResponse.body();

        System.out.println(result);
    }

    /**
     * 查询索引下的所有内容
     * @param indexName
     */
    private static void query_index_all(String indexName){
        HttpResponse httpResponse = HttpUtil.createRequest(Method.GET, url.concat(indexName)
                .concat("/_search")).timeout(3000).execute();

        String result = httpResponse.body();

        System.out.println(result);
    }

    /**
     * 查询索引下的某个字段的内容
     * @param indexName
     * @param keyWord
     */
    private static void query_keyWord(String indexName,String keyWord){
        HttpResponse httpResponse = HttpUtil.createRequest(Method.GET, url.concat(indexName)
                .concat("/_search?q=description:".concat(keyWord))).timeout(3000).execute();

        String result = httpResponse.body();

        System.out.println(result);
    }
}
