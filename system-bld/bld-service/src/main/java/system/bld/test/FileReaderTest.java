package system.bld.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import system.bld.test.bean.GoodsGameDiscounts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/9/8
 * @Time: 15:16
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class FileReaderTest {

	/*public static void main(String[] args) {
		writeFile();
	}*/

	public static void inportFile(){
		FileReader fileReader = new FileReader("D:\\goodsselectconfig.csv");

		List<String> list=fileReader.readLines();

		//行
		for (int i = 0; i < list.size(); i++) {

			String josnStr=list.get(i);

			Map<String,Object> map=JSON.parseObject(josnStr,Map.class);
			//游戏遍历
			for (Map.Entry<String,Object> entry:map.entrySet()){

				Map<String,Object> origin= JSON.parseObject(entry.getValue().toString(), Map.class);

				if("true".equals(origin.get("enable").toString())){
					origin.put("type",1);
				}else{
					origin.put("type",0);
				}
				System.out.println(JSON.toJSONString(origin));

				map.put(entry.getKey(),origin);
			}

			System.out.println("-------- "+JSON.toJSONString(map));
		}
	}


	public static void writeFile(){
		FileWriter writer = new FileWriter("D:\\update.sql");

		List<String > list=new ArrayList<>();
		for (int i = 0; i <1000 ; i++) {
			list.add("i="+i);
		}
		writer.appendLines(list);

	}
}
