package system.bld.test.thread;

import com.google.common.collect.Lists;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.*;

/**
 * @author litao
 * @date 2023-03-31
 * @Desc
 */
public class ThreadPoolTest01 {

    private static ExecutorService executorService = newCachedThreadPool();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int totalThreadPool = 100;
        int num =10;
        Integer b = 0 ;
        for (int i = 0; i < totalThreadPool; i++) {
            Future<Integer> result = executorService.submit(() -> {
                int a =0;
                a = a+1;
               return a;
            });

            b = result.get();

            System.out.println("i:"+i+"  --> "+b);
        }


    }
}
