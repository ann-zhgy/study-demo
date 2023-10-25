package top.ann.zhgy.thread.base;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ann-zhgy
 * @version InterruptThread.class 2023-10-18 14:58
 * @since 2023-10
 */
public class InterruptThread2 {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger();
        Thread thread = new Thread(() -> {
            while (true) {
                count.getAndIncrement();
            }
        });
        thread.start();
        thread.interrupt();
    }
}
