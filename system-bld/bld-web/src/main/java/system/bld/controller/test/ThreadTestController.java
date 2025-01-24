package system.bld.controller.test;

/**
 * @author litao
 * @date 2021-05-21
 * @Desc
 */
public class ThreadTestController {
    static int addNum=0;
    public static void main(String[] args) throws Exception {

        Thread t1=new MyThread01();

        t1.start();
        System.out.println("=========== main ============");
        System.out.println("-- 00=="+addNum);
        Thread t2=new MyThread02();

        t2.start();
        System.out.println("-- 01=="+addNum);
        t1.join();
        t2.join();
        System.out.println("-- 02=="+addNum);
    }

    static class MyThread01 extends Thread{

        @Override
        public void run(){
            System.out.println("this is a thread MyThread01");

            addNum=+1;
            System.out.println("MyThread01="+addNum);
        }

    }

    static class MyThread02 extends Thread{

        @Override
        public void run(){
            System.out.println("this is a thread MyThread02");
            addNum=+1;
            System.out.println("MyThread02="+addNum);
        }

    }
}
