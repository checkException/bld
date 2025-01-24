package system.bld.test.bean;

/**
 * @author litao
 * @date 2022-05-23
 * @Desc
 */
public class SingletionTest {
    private static  final  SingletionTest INSTANCE= new SingletionTest();
    private static int NUM=0;
    private int NUM_COMMON=0;

    public SingletionTest() {
        //System.out.println("我是无参构造器，SingletionTest（）INSTANCE："+INSTANCE);
        NUM++;
        NUM_COMMON++;
    }

    public static final SingletionTest getInstance(){
        System.out.println("我被调佣了，SingletionTest");
        NUM++;
        return SingletionTest.INSTANCE;
    }

    public static int getNUM() {
        return NUM;
    }

    public static void setNUM(int NUM) {
        SingletionTest.NUM = NUM;
    }

    public int getNUM_COMMON() {
        return NUM_COMMON;
    }
}
