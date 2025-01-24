package system.bld.test.writesql;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;

/**
 * @author litao
 * @date 2024-10-12
 * @Desc
 */
public class 订单保护旧代理初始化 {

    public static void getAgentId(){

        String querySql = "SELECT id AS channelId,user_id AS userId FROM dbzhuser.user_marketing_channel WHERE id IN(" +
                "SELECT DISTINCT channel_id FROM dbzhorder.order_bar_protect_records WHERE create_time>'2024-09-10'" +
                ")";

        JSONObject bodyJson = new JSONObject();
        bodyJson.put("db","db1_master");
        bodyJson.put("sql",querySql);
        bodyJson.put("no_limit",1);

        String url = "https://dss.uhaozu.com/api/execute";
        String result = HttpRequest.post(url).contentType("application/json").body(bodyJson.toJSONString())
                .execute()
                .body();

        System.out.println(result);

    }

    public static void main(String[] args) {
        getAgentId();
    }
}
