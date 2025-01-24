package system.bld.test.thread;

import system.bld.test.bean.SingletionTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author litao
 * @date 2021-11-03
 * @Desc
 */
public class ThreadTest01 extends Thread {

    private  ReentrantLock lock =new ReentrantLock();

    private static Integer num =1;
    /**
     * If this thread was constructed using a separate
     * <code>Runnable</code> run object, then that
     * <code>Runnable</code> object's <code>run</code> method is called;
     * otherwise, this method does nothing and returns.
     * <p>
     * Subclasses of <code>Thread</code> should override this method.
     *
     * @see #start()
     * @see #stop()
     */
    @Override
    public void run() {
        System.out.println(getName()+"这是线程开始-第1步");
        SingletionTest singletionTest =new SingletionTest();
        System.out.println(getName()+" 第二步 ："+SingletionTest.getNUM());
        System.out.println(getName()+" 第二步getNUM_COMMON ："+singletionTest.getNUM_COMMON());
        //threadLock(getName());

    }

    public void sub(String name){



    }

    public void threadLock(String name){

        try {
            lock.lock();
            System.out.println(getName()+"执行前我是："+num);
            num=num+1;
            System.out.println(name+"执行后我是："+num);
        }catch (Exception e){

            System.out.println("---");
        }finally {
            lock.unlock();
            System.out.println(name+"执行完毕");
        }

    }

    public static void main(String[] args) {

        try {
            /*for (int i = 0; i < 5; i++) {
                Thread.sleep(10);
                new ThreadTest01().start();

            }*/

            Thread th1=new ThreadTest01();
            Thread th2=new ThreadTest01();
            Thread th3=new ThreadTest01();

            th1.start();
            th2.start();
            th3.start();
            SingletionTest.setNUM(5);
            Thread.sleep(1000);
            System.out.println(" 第三步 ："+SingletionTest.getNUM());
        }catch (Exception e){

        }

    }
}
