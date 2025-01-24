package system.bld.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author litao
 * @date 2023-01-06
 * @Desc
 */
public class ThreadTest03 {

    public static void main(String[] args) throws Exception {
        //FeatureTes();
        threadTest();
    }


    private static void FeatureTes() throws InterruptedException, ExecutionException{
        long start = System.currentTimeMillis();

        // 等凉菜
        Callable ca1 = new Callable(){

            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "凉菜准备完毕";
            }
        };
        FutureTask<String> ft1 = new FutureTask<String>(ca1);
        new Thread(ft1).start();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Callable ca2 = new Callable(){

            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "包子准备完毕";
            }
        };
        FutureTask<String> ft2 = new FutureTask<String>(ca2);
        new Thread(ft2).start();

        System.out.println(ft1.get());
        System.out.println(ft2.get());

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));
    }


    private static void threadTest() throws InterruptedException{
        long start = System.currentTimeMillis();

        // 等凉菜 -- 必须要等待返回的结果，所以要调用join方法
        Thread t1 = new ColdDishThread();
        t1.start();
        t1.join();

        // 等包子 -- 必须要等待返回的结果，所以要调用join方法
        Thread t2 = new BumThread();
        t2.start();
        t2.join();

        long end = System.currentTimeMillis();
        System.out.println("准备完毕时间："+(end-start));
    }

    static class BumThread extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(1000*3);
                System.out.println("包子准备完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ColdDishThread extends Thread{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("凉菜准备完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
