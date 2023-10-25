package top.ann.zhgy.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ann-zhgy
 * @version Demo.class 2023-10-24 10:01
 * @since 2023-10
 */
public class Demo {
    AtomicInteger num = new AtomicInteger();

    public int increment() {
        return num.addAndGet(1);
    }
}
