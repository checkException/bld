package system.bld.main;


import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/5/6
 * @Time: 17:49
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class createSqlUtil {

	public static void main(String[] args) {
		//daoruStr();

		daoruTxt();
	}

	public static  void daoruStr(){
		String ymStr="72fz.com," +
				"8aok.cn," +
				"hxdgzs.com," +
				"cfxdgzs.com," +
				"997wg.com," +
				"yy6494.com," +
				"95fz.cn," +
				"cfxiaoke.com," +
				"223wg.com," +
				"faka.me," +
				"wg177.cn," +
				"63wg.com," +
				"wg177.cn," +
				"bjkdzk.com," +
				"mm5920.com," +
				"1t3g.cn," +
				"688wl.cccpan.com," +
				"xiaohaizi.cccpan.com," +
				"595wg.com," +
				"sqdgzs.cn," +
				"qiao4.cn," +
				"cf886.cn," +
				"yy3716.cn," +
				"yy4507.cn," +
				"520gua.com," +
				"520faka.cn," +
				"432wg.com," +
				"066fz.com," +
				"faka.me," +
				"lgg520.com," +
				"lg913.cccpan.com," +
				"zooxr.com";

		List<String> list= Arrays.asList(ymStr.split(","));

		StringBuffer sql=new StringBuffer("INSERT INTO `uhaofile`.`uhao_pattern_data` (`pattern_id`, `pattern_type`, `data_len`, `databuffer`, `time`, `is_const`, `reversed`, `virus_wg_type`, `feature_code_type`, `over_time`, `create_time`, `operate_name`, `operate_no`) VALUES");

		for (String str:list){
			sql.append("('102', '30400', LENGTH('0:2:"+str+"'), '0:2:"+str+"', NOW(), '1', '"+str+"', '2', '0', NOW(), NOW(), 'admin', 'admin'),\n");

		}

		System.out.println(sql);
	}

	public static void daoruTxt(){
		FileReader fileReader=new FileReader("D:\\waiguaweb.txt");
		List<String> list= fileReader.readLines();
		String sql="INSERT INTO `uhaofile`.`uhao_pattern_data` (`pattern_id`, `pattern_type`, `data_len`, `databuffer`, `time`, `is_const`, `reversed`, `virus_wg_type`, `feature_code_type`, `over_time`, `create_time`, `operate_name`, `operate_no`) VALUE ";

		for (String str:list){
			String sqlStr="('92', '30400', LENGTH('0:2:"+str+"'), '0:2:"+str+"', NOW(), '1', '"+str+"', '2', '0', NOW(), NOW(), 'admin', 'admin');";
			System.out.println(sql.concat(sqlStr));
		}


		//String keyStr=fileReader.readString();
	}
}
