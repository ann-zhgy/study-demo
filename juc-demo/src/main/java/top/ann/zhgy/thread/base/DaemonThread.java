package top.ann.zhgy.thread.base;

/**
 * @author ann-zhgy
 * @version DaemonThread.class 2023-10-18 14:35
 * @since 2023-10
 */
public class DaemonThread {
    public static void main(String[] args) {
        demo1();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void demo1() {
        Thread thread = new Thread(() -> System.out.println("runnable"));
        thread.setDaemon(true);
    }
}
