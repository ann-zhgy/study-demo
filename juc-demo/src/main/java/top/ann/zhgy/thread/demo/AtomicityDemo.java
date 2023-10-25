package top.ann.zhgy.thread.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ann-zhgy
 * @version AtomicityDemo.class 2023-10-13 15:44
 * @since 2023-10
 */
public class AtomicityDemo {
    private volatile int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicityDemo incrementDemo = new AtomicityDemo();
        int threadCount = 100000;
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < threadCount; i++) {
            executorService.execute(() -> {
                incrementDemo.increment();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(incrementDemo.getCount());
    }
}
