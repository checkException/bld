package system.bld.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.csv.CsvData;
import cn.hutool.core.text.csv.CsvReader;
import cn.hutool.core.text.csv.CsvRow;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;

import java.util.*;

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
//		importExcel();
        //importExcelAndExportExcel();
        importExcel01();
	}

	public static void  importExcel01(){
		ExcelReader excelReader= ExcelUtil.getReader(FileUtil.file("D:\\export/excel/oneyear_1226.xlsx"));

		List<Map<String,Object>> readAll = excelReader.readAll();

//		StringBuffer stringBuffer=new StringBuffer();
        Set<String> parentMenuSet = new HashSet<>();
		int count=1;
		/*for (Map<String,Object> map:readAll) {
		    String value = MapUtil.getStr(map,"新boss一级菜单");
		    if(StrUtil.isBlank(value)){
		        continue;
            }

		}*/

        System.out.println(parentMenuSet.size());
//		List<String> list= Arrays.asList(stringBuffer.toString().split(","));

//		System.out.println(list.size());



	}

	public static void  importExcel(){
		ExcelReader excelReader= ExcelUtil.getReader(FileUtil.file("D:\\export/111111.xlsx"));

		List<Map<String,Object>> readAll = excelReader.readAll();

//		StringBuffer stringBuffer=new StringBuffer();
        Set<String> parentMenuSet = new HashSet<>();
		int count=1;
		for (Map<String,Object> map:readAll) {
		    String value = MapUtil.getStr(map,"新boss一级菜单");
		    if(StrUtil.isBlank(value)){
		        continue;
            }
            System.out.println(count+" ------- "+value);
            parentMenuSet.add(value);
            count++;
		}

        System.out.println(parentMenuSet.size());
//		List<String> list= Arrays.asList(stringBuffer.toString().split(","));

//		System.out.println(list.size());



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

	public static void  importExcel3() {
		ExcelReader excelReader = ExcelUtil.getReader(FileUtil.file("D:\\bargainNum.xls"));

		List<Map<String, Object>> readAll = excelReader.readAll();

		List<String> sqlList=new ArrayList<>();

		int count=0;
		for (Map<String, Object> map : readAll) {
			String stringBuffer="UPDATE goods_select_config SET bargain_goods_num=";
			String userId=map.get("user_id").toString();
			String jsonStr=map.get("bargain_num").toString();


			stringBuffer=stringBuffer.concat(jsonStr).concat(" WHERE user_id=").concat(userId).concat(";");
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

    public static void  importExcelAndExportExcel() {
        ExcelReader excelReader = ExcelUtil.getReader(FileUtil.file("D:\\excel/1111111111.xlsx"));

        List<Map<String, Object>> readAll = excelReader.readAll();

        float orderTotalCount =1279224;
        float completeTotalCount =923227;
        String mapStr = "{\"10065\":\"租号酷-QQ飞车手游-V12\",\"10060\":\"租号酷-QQ飞车手游-源极之星\",\"10061\":\"租号酷-QQ飞车手游-序列未来\",\"10062\":\"租号酷-QQ飞车手游-大河神卫\",\"10063\":\"租号酷-QQ飞车手游-雷诺\",\"10064\":\"租号酷-QQ飞车手游-T车\",\"10057\":\"租号酷-三国杀移动版-神孙策\",\"10056\":\"租号酷-三国杀移动版-文鸯\",\"10055\":\"租号酷-三国杀移动版-神郭嘉\",\"10054\":\"租号酷-三国杀移动版-神荀彧\",\"10059\":\"租号酷-QQ飞车手游-冰魄\",\"10058\":\"租号酷-QQ飞车手游-孙悟空\",\"22\":\"我的收藏-近期购买\",\"23\":\"app/m大厅-价格排序置顶特价\",\"24\":\"健康系统订单\",\"25\":\"首页-搜索列表\",\"26\":\"PDD自动发货\",\"27\":\"速上商品\",\"28\":\"返利商品\",\"29\":\"一键闪租订单\",\"3\":\"我的收藏\",\"10001\":\"租号酷-王者荣耀-300皮以上\",\"2\":\"大厅-近期购买\",\"10002\":\"租号酷-王者荣耀-200皮以上\",\"1\":\"推送-商品列表\",\"10000\":\"租号酷-王者荣耀-1元专区\",\"7\":\"web-看了又看\",\"30\":\"优选商品专区\",\"10005\":\"租号酷-王者荣耀-250皮以上\",\"6\":\"大厅-置顶商品\",\"10006\":\"租号酷-王者荣耀-国服带妹号\",\"5\":\"商品详情-分享\",\"10003\":\"租号酷-王者荣耀-100皮以上\",\"4\":\"大厅-收藏商品推荐\",\"31\":\"严选商品专区\",\"10004\":\"租号酷-王者荣耀-超多典藏\",\"10009\":\"租号酷-火影忍者-天道超\",\"9\":\"特价专区\",\"10007\":\"租号酷-王者荣耀-【一键闪租】\",\"8\":\"web-猜你喜欢\",\"10008\":\"租号酷-火影忍者-1元专区\",\"10052\":\"租号酷-三国杀移动版-刘焉\",\"10053\":\"租号酷-三国杀移动版-大将军\",\"10050\":\"租号酷-三国杀移动版-有卡\",\"10051\":\"租号酷-三国杀移动版-谋黄忠\",\"10048\":\"租号酷-王者荣耀-V10\",\"10047\":\"租号酷-英雄联盟-周年限定\",\"10049\":\"租号酷-火影忍者-破面带土\",\"10044\":\"租号酷-英雄联盟-可排位\",\"10043\":\"租号酷-英雄联盟-EDG\",\"10046\":\"租号酷-英雄联盟-情人节限定\",\"19\":\"首页-最近购买推荐\",\"10045\":\"租号酷-英雄联盟-龙瞎\",\"17\":\"拼多多下单\",\"18\":\"首页-商品列表\",\"15\":\"大厅-特价商品推荐\",\"16\":\"快捷下单\",\"13\":\"不可租商品\",\"14\":\"零元活动专区\",\"11\":\"租号大厅\",\"12\":\"特价商品\",\"21\":\"首页-我的收藏推荐\",\"10014\":\"租号酷-火影忍者-达鲁伊\",\"10015\":\"租号酷-火影忍者-恶灵飞段\",\"20\":\"大厅-价格排序置顶特价\",\"10016\":\"租号酷-和平精英-螳螂\",\"10017\":\"租号酷-和平精英-木乃伊\",\"10010\":\"租号酷-火影忍者-暴怒带土\",\"10011\":\"租号酷-火影忍者-忍战带土\",\"10012\":\"租号酷-火影忍者-30S\",\"10013\":\"租号酷-火影忍者-木叶创立斑\",\"10040\":\"租号酷-英雄联盟-1元专区\",\"10041\":\"租号酷-英雄联盟-至臻\",\"10042\":\"租号酷-英雄联盟-云顶之弈\",\"10018\":\"租号酷-和平精英-特效枪\",\"10019\":\"租号酷-和平精英-阿斯顿马丁\",\"100\":\"其他\",\"10039\":\"租号酷-穿越火线-斯太尔蝴蝶\",\"10038\":\"租号酷-穿越火线-幻神音效卡\",\"10037\":\"租号酷-穿越火线-幻神\",\"10036\":\"租号酷-穿越火线-爆破号\",\"10035\":\"租号酷-穿越火线-生化号\",\"10034\":\"租号酷-穿越火线-可排位\",\"10033\":\"租号酷-穿越火线-6盘6烈\",\"10032\":\"租号酷-穿越火线-1元专区\",\"10020\":\"租号酷-和平精英-火箭少女\",\"10027\":\"租号酷-手游版CF-音效卡\",\"10028\":\"租号酷-手游版CF-紫电熔岩\",\"10025\":\"租号酷-手游版CF-V9\",\"10\":\"再次购买\",\"10026\":\"租号酷-手游版CF-王者\",\"10023\":\"租号酷-和平精英-雪国\",\"10024\":\"租号酷-手游版CF-1元专区\",\"10021\":\"租号酷-和平精英-五爪金龙\",\"10022\":\"租号酷-和平精英-路特斯\",\"10030\":\"租号酷-手游版CF-至尊\",\"10031\":\"租号酷-手游版CF-幻神\",\"10029\":\"租号酷-手游版CF-黑龙魂\"}";
        Map<String,String> confMap = JSON.parseObject(mapStr,Map.class);
        List<List<String>> excelList=new ArrayList<>();
        for (Map<String, Object> map : readAll) {

            String tag= map.get("tag").toString();
            float orderCount= MapUtil.getFloat(map,"orderCount");
            float completeCount= MapUtil.getFloat(map,"completeCount");
            Integer rentCount= MapUtil.getInt(map,"rentCount");
            String appName= MapUtil.getStr(map,"app_name");

            String tagName =confMap.get(tag);

            List<String> rowList =new ArrayList<>();
            rowList.add(tagName);
            rowList.add(String.valueOf((int)orderCount));
            rowList.add(String.valueOf((int)completeCount));
            rowList.add(String.valueOf(rentCount));
            rowList.add(String.valueOf(NumberUtil.decimalFormat("#.##%",NumberUtil.div(orderCount,orderTotalCount))));
            rowList.add(String.valueOf(NumberUtil.decimalFormat("#.##%",NumberUtil.div(completeCount,completeTotalCount))));
            rowList.add(appName);
            if(confMap.containsKey(tag)){

                System.out.println(confMap.get(tag)+"-"+orderCount+"-"+completeCount+"-"+rentCount);
            }else{
                System.out.println(tag+"-"+orderCount+"-"+completeCount+"-"+rentCount);
            }
            excelList.add(rowList);
        }

        ExcelWriter writer = ExcelUtil.getWriter("D:\\excel/1208导出.xlsx");

        //跳过当前行，既第一行，非必须，在此演示用
        writer.passCurrentRow();

        //一次性写出内容，强制输出标题
        writer.write(excelList, false);
        //关闭writer，释放内存
        writer.close();
    }

}
