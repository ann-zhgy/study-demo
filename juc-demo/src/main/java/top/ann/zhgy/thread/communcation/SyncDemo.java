package top.ann.zhgy.thread.communcation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ann-zhgy
 * @version SyncDemo.class 2023-10-19 10:24
 * @since 2023-10
 */
public class SyncDemo {
    private volatile int flag = 1;

    public synchronized void fun1() {
        try {
            while (flag != 1) {
                wait();
            }
            System.out.println("1");
            flag = 2;
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void fun2() {
        try {
            while (flag != 2) {
                wait();
            }
            System.out.println("2");
            flag = 3;
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void fun3() {
        try {
            while (flag != 3) {
                wait();
            }
            System.out.println("3");
            flag = 1;
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        SyncDemo demo = new SyncDemo();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(demo::fun3);
        executor.execute(demo::fun2);
        executor.execute(demo::fun1);
        executor.shutdown();
    }
}
