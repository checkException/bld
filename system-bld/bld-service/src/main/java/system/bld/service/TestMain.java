package system.bld.service;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.dfa.WordTree;
import com.alibaba.fastjson.JSON;
import system.bld.model.UserBase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/6/10
 * @Time: 16:25
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class TestMain {
	/*public static void main(String[] args) {

		//dateTest();

		//keyWordMacth();

		integerTest();
 	}*/

	/**
	 * 时间格式测试
	 */
	public static void dateTest(){
		System.out.println(DateUtil.parse(DateUtil.format(new Date(), DatePattern.NORM_DATE_PATTERN).concat(" 17:00:00")).compareTo(new Date()));

		System.out.println(DateUtil.parse(DateUtil.format(new Date(), DatePattern.NORM_DATE_PATTERN).concat(" 23:59:59")));
		System.out.println(DateUtil.offsetDay(new Date(),1));

		System.out.println(DateUtil.beginOfDay(new Date()));
		System.out.println(DateUtil.endOfDay(new Date()));

		System.out.println(490/100);

		System.out.println(DateUtil.betweenDay(new Date(), DateUtil.parse("2020-07-03 23:59:59"), false));
		System.out.println(DateUtil.between(new Date(), DateUtil.parse("2020-07-03 23:59:59"), DateUnit.DAY));

		System.out.println(DateUtil.parse("2020-07","yyyy-MM"));
		System.out.println(DateUtil.parse(DateUtil.offsetDay(new Date(),-1).toDateStr(),"yyyyy-MM-dd"));
	}

	/**
	 * dfa算法 关键字过滤
	 */
	public static void keyWordMacth(){
		String text="中华人民共和国（People's Republic of China），简称“中国”，成立于1949年10月1日 [1] " +
				" ，位于亚洲东部，太平洋西岸 [2]  ，" +
				"是工人阶级领导的、以工农联盟为基础的人民民主专政的社会主义国家 [3]  ，" +
				"以五星红旗为国旗 [4]  、《义勇军进行曲》为国歌 [5]  ，国徽内容为国旗、天安门、齿轮和麦稻穗 [6]  ，" +
				"通用语言文字是普通话和规范汉字 [7]  ，首都北京 [8]  ，" +
				"是一个以汉族为主体、56个民族共同组成的统一的多民族国家。";

		text.concat("litao").concat("|uhaozu");
		List<String> wordsList=new ArrayList<>();
		wordsList.addAll( Arrays.asList(new String[]{"中华人民","中国","工人阶级","人民民主专政","社会主义","统一","汉字","民族"}));

		List<String> lists=new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			lists.add(RandomUtil.randomString("abcdefghijklmnopqrstuvwsyz",5));
		}

		wordsList.addAll(lists);
		WordTree tree=new WordTree();
		tree.addWords(wordsList);

		//匹配所有并且列出关键字
		List<String> matchAll = tree.matchAll(text, -1, false, false);
		//只匹配第一个关键字
		String word=tree.match(text);

		//是否含有关键字
		boolean result=tree.isMatch(text);

		System.out.println(matchAll);

		System.out.println(word);

		System.out.println(result);

	}

	public static void integerTest(){
		Integer aa=1000;
		Integer bb=1111;
		Integer cc=aa+bb;

		System.out.println((double)aa/100);
		System.out.println((double)bb/100);
		System.out.println((double)cc/100);

		System.out.println(new BigDecimal(aa).divide(new BigDecimal(100)));
		System.out.println(new BigDecimal(cc).divide(new BigDecimal(100)));
	}

}
