package top.ann.zhgy.thread.communcation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ann-zhgy
 * @version ReentrantLockDemo.class 2023-10-19 10:58
 * @since 2023-10
 */
public class ReentrantLockDemo {
    private int flag = 1;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();

    public void fun1() {
        lock.lock();
        try {
            if (flag != 1) {
                condition1.await();
            }
            System.out.println(1);
            flag = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void fun2() {
        lock.lock();
        try {
            if (flag != 2) {
                condition2.await();
            }
            System.out.println(2);
            flag = 3;
            condition3.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void fun3() {
        lock.lock();
        try {
            if (flag != 3) {
                condition3.await();
            }
            System.out.println(3);
            flag = 1;
            condition1.signal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(demo::fun3);
        executor.execute(demo::fun2);
        executor.execute(demo::fun1);
        executor.shutdown();
    }
}
