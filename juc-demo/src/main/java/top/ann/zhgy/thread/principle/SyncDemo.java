package top.ann.zhgy.thread.principle;

/**
 * @author ann-zhgy
 * @version SyncDemo.class 2023-10-20 14:43
 * @since 2023-10
 */
public class SyncDemo {
    private final Object lock = new Object();

    public void fun() {
        synchronized (lock) {
            System.out.println("sync");
        }
        fun2();
    }

    public static void fun2() {

    }

}
