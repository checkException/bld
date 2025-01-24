package system.bld.service;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @author litao
 * @date 2023-02-07
 * @Desc
 */
public class Test02Test {
    public static void main(String[] args) {
        String str="{\"com.uhzsc.app-ios\":2,\"com.zuhao.app-ios\":2,\"com.zuyimao.app-ios\":2,\"com.zylm.app-ios\":2,\"com.zuyoumao.app-ios\":2,\"com.51zhlm.app-ios\":2,\"com.zuhaoku.app-android\":2,\"com.uhaozu.app-android\":2}";
        Map<String,Integer> map = JSON.parseObject(str,Map.class);

        Long userId = null;
        go:for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            int a =0;
            userId = null;
            while (true){

                if(a==50){
                    continue go;
                }
                a++;
                userId = Long.valueOf(a);
                System.out.println(userId);
            }
        }

    }
}
