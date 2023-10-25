package top.ann.zhgy.thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ann-zhgy
 * @version ReentrantLockDemo.class 2023-10-18 16:45
 * @since 2023-10
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        final Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        condition.signal();
        Runnable task = () -> {
            lock.lock();
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                }
            } finally {
                lock.unlock();
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(task);
        executor.execute(task);
        executor.shutdown();
    }
}
