package system.bld.test;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author litao
 * @date 2022-09-06
 * @Desc
 */
public class HttpTest {

    public static void main(String[] args) {
        List<String> list = JSONArray.parseArray("[\"https://staticapp.uhaozu.com/apk/uhaozu/20041842/KKwPx1zjFf.apk\",\"https://staticapp.uhaozu.com/apk/uhaozu/20041842/ZBH7vbsWkf.apk\",\"https://staticapp.uhaozu.com/apk/uhaozu/20041842/5QTDd5SKEy.apk\"]"
                ,String.class);
        httpCodeTest01(list);
    }


    public static void httpCodeTest01(List<String> list){
        List<JSONObject> resultJson= new ArrayList<>();



        for (int i = 0; i < list.size(); i++) {
            String url = list.get(i);

            HttpResponse response = HttpRequest.head(url).execute();

            int status = response.getStatus();

            JSONObject jsonObject =new JSONObject();
            jsonObject.put("updateAddress",url);
            jsonObject.put("status",status);

            System.out.println(url+"-->"+status);
            resultJson.add(jsonObject);
        }

    }
}
