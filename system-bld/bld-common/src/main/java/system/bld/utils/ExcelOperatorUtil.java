package system.bld.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/7/20
 * @Time: 11:56
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class ExcelOperatorUtil {

	/*public static void main(String[] args) {
		Integer.valueOf(1).equals(null);

		//importXLxuanhao_redirect();
		//importXLSplug_complain_optmization();
		//importExcel2();
		//importExcel();
	}*/

	public static void  importExcel(){
		ExcelReader excelReader= ExcelUtil.getReader(FileUtil.file("D:\\1111111.xls"));

		List<Map<String,Object>> readAll = excelReader.readAll();

		StringBuffer stringBuffer=new StringBuffer();
		int count=1;
		for (Map<String,Object> map:readAll) {
			System.out.println(count+" ----- "+map.get("id"));
			count++;
			stringBuffer.append("'").append(map.get("game_discounts")).append("',");
		}

		System.out.println(stringBuffer.toString());

		List<String> list= Arrays.asList(stringBuffer.toString().split(","));

		System.out.println(list.size());



	}

	public static void  importExcel2() {
		ExcelReader excelReader = ExcelUtil.getReader(FileUtil.file("D:\\goodsselectconfig.xls"));

		List<Map<String, Object>> readAll = excelReader.readAll();

		List<String> sqlList=new ArrayList<>();

		int count=0;
		for (Map<String, Object> map : readAll) {
			String stringBuffer="UPDATE goods_select_config SET game_discounts='";
			String id= map.get("id").toString();

			String jsonStr=map.get("game_discounts").toString();
			Map<String,Object> configMap= JSON.parseObject(jsonStr,Map.class);
			//游戏遍历
			for (Map.Entry<String,Object> entry:configMap.entrySet()){

				Map<String,Object> origin= JSON.parseObject(entry.getValue().toString(), Map.class);

				if("true".equals(origin.get("enable").toString())){
					origin.put("type",1);
				}else{
					origin.put("type",0);
				}
				configMap.put(entry.getKey(),origin);
				//System.out.println(JSON.toJSONString(origin));
			}

			stringBuffer=stringBuffer.concat(JSON.toJSONString(configMap)).concat("' WHERE id='").concat(id).concat("';");
			//System.out.println(id+"-------- "+JSON.toJSONString(configMap));

			System.out.println(stringBuffer);
			sqlList.add(stringBuffer);
			count++;
		}
		System.out.println("执行行数："+count);

		FileWriter writer = new FileWriter("D:\\update.sql","UTF-8");
		writer.writeLines(sqlList);
	}

	public static void importXLSplug_complain_optmization(){

		ExcelReader excelReader = ExcelUtil.getReader(FileUtil.file("D:\\plug_complain_optmization.xls"));

		List<Map<String, Object>> readAll = excelReader.readAll();

		List<String> sqlList=new ArrayList<>();

		int count=0;
		for (Map<String, Object> map : readAll) {
			String stringBuffer="UPDATE user_merchant_auth SET open_time='";
			String id= map.get("user_id").toString();

			String openTime=map.get("open_time").toString();


			stringBuffer=stringBuffer.concat(openTime).concat("' WHERE user_id=").concat(id).concat(";");
			//System.out.println(id+"-------- "+JSON.toJSONString(configMap));

			System.out.println(stringBuffer);
			sqlList.add(stringBuffer);
			count++;
		}
		System.out.println("执行行数："+count);

		sqlList.add("-- 兼容 过期时间为null的数据");
		sqlList.add("UPDATE user_merchant_auth SET open_time=create_time WHERE expire_time IS NULL;");
		FileWriter writer = new FileWriter("D:\\plug_complain_optmization_init.sql","UTF-8");
		writer.writeLines(sqlList);
	}

	public static void importXLxuanhao_redirect(){

		ExcelReader excelReader = ExcelUtil.getReader(FileUtil.file("D:\\工作簿2.xls"));

		List<Map<String, Object>> readAll = excelReader.readAll();

		List<String> sqlList=new ArrayList<>();

		int count=0;
		String stringBuffer="UPDATE `dbzhgoods`.`goods_select_config` SET domain_status=0 WHERE user_id IN (";
		for (Map<String, Object> map : readAll) {

			String id= map.get("id").toString();


			stringBuffer=stringBuffer.concat(id).concat(",");
			//System.out.println(id+"-------- "+JSON.toJSONString(configMap));

			count++;
		}
		System.out.println("执行个数："+count);
		stringBuffer=stringBuffer.substring(0,stringBuffer.length()-1);
		stringBuffer=stringBuffer.concat(");");
		System.out.println(stringBuffer);
		sqlList.add(stringBuffer);
		FileWriter writer = new FileWriter("D:\\xuanhao_redirect.sql","UTF-8");
		writer.writeLines(sqlList);
	}

}
