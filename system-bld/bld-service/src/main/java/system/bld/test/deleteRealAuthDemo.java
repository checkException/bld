package system.bld.test;

import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.lang.Dict;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.MapUtils;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author litao
 * @date 2023-06-08
 * @Desc
 */
public class deleteRealAuthDemo {

//    private static String url ="http://localhost:8080/api/realAuth/deleteRealAuth";
//    private static String url ="http://situhaozuapi.17of.com/api/realAuth/deleteRealAuth";
    private static String url ="http://uhaozuapi.17of.com/api/realAuth/deleteRealAuth";


    /**
     * 清空 CSV中的用户实名认证信息
     */
    public static void inportFile(){

        FileReader fileReader = new FileReader("D:\\deleteRealAuth.csv");

        List<String> list=fileReader.readLines();

        HttpCookie httpCookie1 = new HttpCookie("employeenum", "4001");
        HttpCookie httpCookie2 = new HttpCookie("employeename", "%C0%EE%CC%CE");
        //行
        for (int i = 0; i < list.size(); i++) {

            Long userId=Long.valueOf(list.get(i));

            /*if(userId.equals(Long.valueOf(30249257))){

                continue;
            }*/
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("userId",userId);
            String body = HttpRequest.post(url)
                    .cookie(httpCookie1,httpCookie2)
                    .contentType("application/json")
                    .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                    .header("Accept-Encoding","gzip, deflate, br")
                    .header("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8")
                    .header("Accept","*/*")
                    .header("Connection","keep-alive")
                    .header("Origin","http://uhaozusub.17of.com")
                    .header("Host","uhaozuapi.17of.com")
                    .header("Referer","http://uhaozusub.17of.com")
                    .header("Cookie","employeenum=4001; sitemployeeId=1012; employeename=%C0%EE%CC%CE; name=%C0%EE%CC%CE; employeeId=1029")
                    .body(jsonObject.toString())
                    .execute()
                    .body();

            System.out.println(body);

        }
    }

    /**
     * 冻结CSV中的用户
     */
    public static void forzenUser(){
        String url ="http://uhaozuapi.17of.com/api/user/frozenUsersWithReason";
        FileReader fileReader = new FileReader("D:\\forzenUser.csv");

        List<String> list=fileReader.readLines();

        HttpCookie httpCookie1 = new HttpCookie("employeenum", "4001");
        HttpCookie httpCookie2 = new HttpCookie("employeename", "%C0%EE%CC%CE");
        //行
        List<Long> userIds = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            Long userId=Long.valueOf(list.get(i));
//            Long userId=Long.valueOf(1000002);
//            Long userId=Long.valueOf(1003212);

            userIds.add(userId);

        }

        /*Long userId=Long.valueOf(1003212);

        userIds.add(userId);*/

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userIds", userIds);
        jsonObject.put("type", 1);
        jsonObject.put("frozenDay", 9999);
        jsonObject.put("frozenReasonType", 26);
        jsonObject.put("frozenReason", "利用平台诈骗");


        String body = HttpRequest.post(url)
                .cookie(httpCookie1,httpCookie2)
                .contentType("application/json")
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Accept-Language","zh-CN,zh;q=0.9,en;q=0.8")
                .header("Accept","*/*")
                .header("Connection","keep-alive")
                .header("Origin","http://uhaozusub.17of.com")
                .header("Referer","http://uhaozusub.17of.com")
                .header("Host","uhaozuapi.17of.com")
                .header("Cookie","employeenum=4001; sitemployeeId=1012; employeename=%C0%EE%CC%CE; name=%C0%EE%CC%CE; employeeId=1029")
                .body(jsonObject.toString())
                .execute()
                .body();

        System.out.println(body);
    }


    public static void main(String[] args) {
        //清空 CSV中的用户实名认证信息
//        inportFile();
        //冻结CSV中的用户
        forzenUser();
    }
}
