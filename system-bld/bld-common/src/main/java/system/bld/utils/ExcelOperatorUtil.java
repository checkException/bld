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

	public static void main(String[] args) {
		Integer.valueOf(1).equals(null);

		//importXLxuanhao_redirect();
		//importXLSplug_complain_optmization();
		//importExcel2();
		//importExcel();
	}

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


		String aaa="'Cheat_Generic_Jfh3','Cheat_Generic_ST1','hb001','nbts61','gj_2','qingkong_2','Cheat_Generic_CA2','LOL_Skin7','Cheat_Generic_ADC','Cheat_Generic_Dzx1'," +
				"'Cheat_Generic_GuoGuo1','Cheat_Generic_cxll1','Cheat_Generic_CX1','Cheat_Generic_Xbs1','Cheat_Generic_txl','godeyes','Cheat_Generic_em1','Cheat_Generic_Peak2'," +
				"'tianjiang','Cheat_Generic_Mj4','cheat_generic_lg','Cheat_Generic_Xbs2','Cheat_Generic_Xbs3','Cheat_Generic_fw2','Cheat_Generic_Lgwh1','Cheat_Generic_LeiLong1'," +
				"'Cheat_Generic_Lgwh2','Cheat_Generic_KeyLogger1','Cheat_Generic_Xbs4','Cheat_Generic_Gr2','tulu009','tulu005','tulu006','yunduan','beiliang1','beiliang2'," +
				"'Cheat_Generic_leishe1','KB','Cheat_Generic_47','Cheat_Generic_BT1','Cheat_Gneric_Hy_1','Cheat_Generic_Sf2','PUBG_PX','Cheat_Generic_TJ','Cheat_Generic_NCLoader1'," +
				"'YdArk','Cheat_Generic_kk1','Cheat_Generic_twqd2','顺丰','Cheat_Generic_SF8','Cheat_Generic_SF9','Cheat_Generic_SF10','Cheat_Generic_LD2','Cheat_Generic_TH','Cheat1'," +
				"'Cheat_Generic_Cheat1','Cheat_Generic_Ss1','Cheat_Generic_CFGA','2.8.8','Cheat_Generic_SS','Cheat_Generic_HN','Cheat_generic_DL5','Cheat_generic_th5'," +
				"'Cheat_Generic_Nm2','Cheat_Generic_LS6','CheatGeneric_GG','Ds2','Cheat_Generic_Jqm2','huaqiangu2','Cheat_Generic_Jk1','Cheat_Generic_VC1','Cheat_Generic_FX6'," +
				"'Cheat_Generic_FX7','Cheat_Generic_DM5','Cheat_Generic_GodEyes1','SuperMan_CFDh2','Cheat_Generic_xx01','Cheat_Generici_QL8','Cheat_Generic_zxc2','Cheat_Generic_HH1'," +
				"'Cheat_Generic_Nice1','tangmu','Cheat_Generic_Syw1','Cheat_Generic_JK','Cheat_Generic_KK001','Cheat_Generic_hzw1','Cheat_Generic_Dream1','yangguang','Cheat_Generic_Leishe9'," +
				"'huitailang','企鹅','Cheat_Generic_nb5','Cheat_Generic_Jdbox1','fanren','shaonian','Cheat_Generic_LMU','Cheat_Generic_MM1','Cheat_Generic_RPK1','Cheat_Generic_TH001','yewei'," +
				"'Cheat_Generic_WOW2','Cheat_Generic_DZH','Cheat_Generic_JKX','Cheat_Generic_HCR','Cheat_Generic_Wnyq2','Cheat_Generic_RGB1','wuyun','Cheat_Generic_XR','xdylw'";

		List<String> list1= Arrays.asList(aaa.split(","));

		System.out.println(list1.size());
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
