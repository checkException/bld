package system.bld;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import system.bld.response.TurntablePrizeDomain;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: LiTao
 * @Date: 2020/10/13
 * @Time: 9:55
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class RandTest {
	public static void main(String[] args) {
		/*for (int i = 0; i < 1000; i++) {
			//drawTest();

			generatePrizes();
		}*/
        ClassTest();
	}

	public static  void ClassTest(){
        Class cls1 = String.class;

        String s = "Hello";
        Class cls2 = s.getClass();

        System.out.println(cls1==cls2);
    }
	public static void drawTest(){

		List<Pair<String, Double>> list = new ArrayList<>();

		Pair<String, Double> pair = new MutablePair<>("一等奖",Double.valueOf("20"));
		Pair<String, Double> pair1 = new MutablePair<>("二等奖",Double.valueOf("20"));
		Pair<String, Double> pair2 = new MutablePair<>("三等奖",Double.valueOf("59"));
		Pair<String, Double> pair3 = new MutablePair<>("四等奖",Double.valueOf("1"));
		list.add(pair);
		list.add(pair1);
		list.add(pair2);
		list.add(pair3);

		TreeMap<Double, String> weightMap = new TreeMap<>();
		for (Pair<String, Double> item : list) {
			double lastWeight = weightMap.size() == 0 ? 0 : weightMap.lastKey().doubleValue();
			weightMap.put(item.getValue().doubleValue() + lastWeight, item.getKey());
		}

		double randomWeight = weightMap.lastKey() * Math.random();
		SortedMap<Double, String> tailMap = weightMap.tailMap(randomWeight, false);
		String turntablePrizeDomain = weightMap.get(tailMap.firstKey());

		if(turntablePrizeDomain.equals("四等奖")){
			System.out.println("---------------------------------四等奖--------------");
		}
		System.out.println(turntablePrizeDomain);
	}

	private static void generatePrizes() {
		String jsonStr="[{\"prizeLevel\":\"四等奖\",\"prizeDesc\":\"满5元减1元的红包！\",\"redPackId\":303,\"weight\":20},{\"prizeLevel\":\"五等奖\",\"prizeDesc\":\"满3.8元减0.3元的红包！\",\"redPackId\":342,\"weight\":20},{\"prizeLevel\":\"谢谢参与\",\"prizeDesc\":\"姿势不对，再试一次。\",\"redPackId\":-1,\"weight\":59},{\"prizeLevel\":\"六等奖\",\"prizeDesc\":\"会员体验卡\",\"redPackId\":null,\"entityId\":0,\"weight\":1},{\"prizeLevel\":\"二等奖\",\"prizeDesc\":\"廉颇无尽征程皮肤\",\"redPackId\":null,\"entityId\":5,\"weight\":0},{\"prizeLevel\":\"特等奖\",\"prizeDesc\":\"特斯拉皮肤\",\"redPackId\":null,\"entityId\":4,\"weight\":0}]";
		List<TurntablePrizeDomain> prizeList = JSON.parseArray(jsonStr, TurntablePrizeDomain.class);
		List<Pair<TurntablePrizeDomain, Double>> list = new ArrayList<>();

		// 获取谢谢参与
		TurntablePrizeDomain thankJoin=new TurntablePrizeDomain();

		for (TurntablePrizeDomain turntablePrizeDomain : prizeList) {
			Pair<TurntablePrizeDomain, Double> pair = new MutablePair<>(turntablePrizeDomain,
					turntablePrizeDomain.getWeight());
			list.add(pair);

			if(Long.valueOf("-1").equals(turntablePrizeDomain.getRedPackId())){
				thankJoin=turntablePrizeDomain;
			}
		}

		TreeMap<Double, TurntablePrizeDomain> weightMap = new TreeMap<>();
		for (Pair<TurntablePrizeDomain, Double> item : list) {
			double lastWeight = weightMap.size() == 0 ? 0 : weightMap.lastKey().doubleValue();
			weightMap.put(item.getValue().doubleValue() + lastWeight, item.getKey());
		}

		double randomWeight = weightMap.lastKey() * Math.random();
		SortedMap<Double, TurntablePrizeDomain> tailMap = weightMap.tailMap(randomWeight, false);
		TurntablePrizeDomain turntablePrizeDomain = weightMap.get(tailMap.firstKey());

		//校验实体奖品抽取规则
		if(ObjectUtil.isNotNull(turntablePrizeDomain.getEntityId())){
			//0代表是会员体验卡 ；
			if(Long.valueOf(0).equals(turntablePrizeDomain.getEntityId())){
				System.out.println("====================="+turntablePrizeDomain.getPrizeDesc());
			}else{
				//System.out.println(turntablePrizeDomain.getPrizeDesc());
			}
		}

		System.out.println(turntablePrizeDomain.getPrizeDesc());
	}
}
