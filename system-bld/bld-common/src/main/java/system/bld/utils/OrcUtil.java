package system.bld.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.map.MapUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author litao
 * @date 2022-04-14
 * @Desc
 */
public class OrcUtil {



    public static String imgToBase64(String imgPath){

        InputStream inputStream =null;
        byte[] bytes =null;
        try {

            inputStream = new FileInputStream(imgPath);

            bytes = new byte[inputStream.available()];

            inputStream.read(bytes);

        }catch (Exception e){

        }
        finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return Base64.encode(bytes);
    }

    public static String strToConent(String content){

        Map param = MapUtil.newHashMap();
        //param.put("image","data:image/jpeg;base64,"+ content.substring(2,content.length()-1));
        param.put("image","data:image/jpeg;base64,"+ content);
        param.put("image_url","");
        param.put("type","https://aip.baidubce.com/rest/2.0/ocr/v1/general_basic");
        param.put("detect_direction","false");


        String response = HttpRequest.post("https://cloud.baidu.com/aidemo")
                .header("Host","cloud.baidu.com")
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.114 Safari/537.36 Edg/89.0.774.76")
                .header("Accept","*/*")
                .header("Origin","https://cloud.baidu.com")
                .header("Sec-Fetch-Site","same-origin")
                .header("Sec-Fetch-Mode","cors")
                .header("Sec-Fetch-Dest","empty")
                .header("Referer","https://cloud.baidu.com/product/ocr/general")
                .header("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .form(param)
                .execute().body();

        System.out.println(response);

        return response;
    }

    public static void main(String[] args) {

        //String content = imgToBase64("D:/home/img.jpg");
        String content = imgToBase64("D:/home/img.png");
        String response = strToConent(content);

        Map<String,Object> result =JSON.parseObject(response,Map.class);
        Map<String,Object> resultDate =JSON.parseObject(result.get("data").toString(),Map.class);
        JSONArray resultArr =JSON.parseArray(resultDate.get("words_result").toString());

        for (int i = 0; i <resultArr.size() ; i++) {
            System.out.println(resultArr.get(i));
        }

    }
}
