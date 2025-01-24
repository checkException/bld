package system.bld.test;

import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author litao
 * @date 2025-01-07
 * @Desc  stream 流操作demo
 */public class StreamTest {

    static List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7,8,9,10,9);
    static List<Integer> list01 = Lists.newArrayList(10,11,12,13,14,15,16,17,18,19);
    static List<String> listStr = Lists.newArrayList("litao","xiaoshan","zhangsi","piter");

    public static void streamDemo(){
        //截断 移除右边的
        Stream<Integer> limitStream = list.stream().limit(4);
        System.out.println("截断:"+limitStream.collect(Collectors.toList()));
        // 跳过 跳过左边的
        System.out.println("跳过:"+list.stream().skip(4).collect(Collectors.toList()));


        // 排序 默认自然顺序排序
        System.out.println("排序:"+list.stream().sorted().collect(Collectors.toList()));
        System.out.println("自定义排序:"+list.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                System.out.println(o1+":--- --- ---:"+o2);
                return o1 - o2;
            }
        }).collect(Collectors.toList()));

        System.out.println("按照字符串长度排序："+ listStr.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()));
        System.out.println("按照字符串长度排序 长-> 短："+ listStr.stream().sorted(Comparator.comparingInt(String::length).reversed()).collect(Collectors.toList()));
        System.out.println("排序后取最大值max："+list.stream().max(Comparator.comparing(Integer::intValue)).orElse(100));
        System.out.println("排序后取最小值min："+list.stream().min(Comparator.comparing(Integer::intValue)).orElse(100));
        System.out.println("去重："+list.stream().distinct().collect(Collectors.toList()));

        list01.stream().skip(8).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                    System.out.println("skip+forEach:"+integer);
            }
        });

        System.out.println("findAny:"+ listStr.stream().findAny().orElse("litao"));
//        orElse 表示查找不到数据时默认返回的数据
        System.out.println("查找litao的关键字:"+ listStr.stream().filter(string -> "litao".equals(string)).findAny().orElse("null"));
    }
    public static void filterDemo1(){

        // 创建stream流
        Stream.Builder<Integer> streamBu = Stream.builder();

        streamBu.add(1);
        streamBu.add(2);
        streamBu.add(3);
        streamBu.add(4);
        streamBu.add(5);
        streamBu.add(6);
        Stream<Integer> integerStream = streamBu.build();
        List<Integer> integerList = integerStream.collect(Collectors.toList());
        // 过滤出偶数
        Stream<Integer> evenNum = integerList.stream().filter(it -> it%2 == 0);
        System.out.println("filter 过滤出偶数:"+evenNum.collect(Collectors.toList()));

    }

    /**
     * 扁平映射（FlatMap）：
     */
    public static void flatMapDemo1(){

        // 创建stream流
        List<List<Integer>> listList = new ArrayList<>();
        listList.add(Arrays.asList(1,2,3));
        listList.add(Arrays.asList(3,4,5));
        listList.add(Arrays.asList(6,7,8));
        Stream<Integer> integerStream = listList.stream().flatMap(List::stream);
        System.out.println("flatMap 嵌套list 组合成一个:"+integerStream.collect(Collectors.toList()));

//        System.out.println(integerStream.findAny().orElse(1));
//        System.out.println(integerStream.filter(integer -> true).findAny().orElse(1));

    }

    /**
     * map
     */
    public static void mapDemo(){
        List<String> lengthList = Arrays.asList("hello world","hello kids","xiao zhai zi","xiao fei ji");
        System.out.println("map元素长度组合成集合:"+lengthList.stream().map(string -> string.length()).collect(Collectors.toList()));

        Map<Integer,List<String>> map = lengthList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("分组map:"+map);
    }

    /**
     * reduce
     */
    public static void reduceDemo() {

        System.out.println("reduce.sum_01:"+list.stream().reduce(0,Integer::sum).intValue());
        System.out.println("reduce.sum_02:"+list.stream().reduce(Integer::sum).orElse(10).intValue());
        System.out.println("reduce.maxBy_03:"+list.stream().reduce(BinaryOperator.maxBy(Comparator.comparingInt(Integer::intValue))).orElse(10000).intValue());
        System.out.println("reduce.累乘:"+list.stream().reduce((a,b)-> a*b).orElse(1000000));
    }

    /**
     * parallel 并行流 处理
     */
    public static void parallelDemo(){
        // 并行处理
        list.parallelStream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("parallelStream:"+integer);
            }
        });
        list.stream().parallel().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("parallel:"+integer);
            }
        });
        list.stream().parallel().forEachOrdered(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("parallel->forEachOrdered:"+integer);
            }
        });
    }

    public static void main(String[] args){
        /*streamDemo();
        filterDemo1();
        flatMapDemo1();
        mapDemo();
        reduceDemo();*/
        parallelDemo();
    }

}
