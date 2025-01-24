package system.bld.test.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author litao
 * @date 2022-08-23
 * @Desc
 */
public class ThreadTest02 {

    private static final int THREAD_COUNT = 20;

    private static AtomicInteger count = new AtomicInteger(0) ;

    private static int count_1 = 0 ;

    public static void increase(){
        count.incrementAndGet() ;
        count_1++;
        //System.out.println(count);
    }

    public static void main(String[] args) {
        Thread[] thread = new Thread[THREAD_COUNT];
        for (int i = 0; i <  THREAD_COUNT; i++) {
            thread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });

        }

        for (int i = 0; i < THREAD_COUNT; i++) {
            thread[i].start();
        }
        while (Thread.activeCount()>2){
            //System.out.println(count);
            Thread.yield();
        }

        System.out.println(count);
        System.out.println(count_1);
    }
}
