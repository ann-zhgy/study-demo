package top.ann.zhgy.thread.lock;

/**
 * @author ann-zhgy
 * @version SynchronizedDemo.class 2023-10-18 16:34
 * @since 2023-10
 */
public class SynchronizedDemo {
    public static void main(String[] args) {

    }

    public void func() {
        synchronized (this) {
            System.out.println("synchronized block");
        }
    }

    public synchronized void syncFunc() {
        System.out.println("synchronized function");
    }

    public static synchronized void staticSyncFunc() {
        System.out.println("static synchronized function");
    }

}
