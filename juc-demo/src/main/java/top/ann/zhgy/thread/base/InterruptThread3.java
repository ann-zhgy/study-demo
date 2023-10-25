package top.ann.zhgy.thread.base;

/**
 * @author ann-zhgy
 * @version InterruptThread.class 2023-10-18 14:58
 * @since 2023-10
 */
public class InterruptThread3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!Thread.interrupted()) {
                System.out.println("runnable");
            }
            System.out.println("runnable end");
        });
        thread.start();
        thread.interrupt();
    }
}
