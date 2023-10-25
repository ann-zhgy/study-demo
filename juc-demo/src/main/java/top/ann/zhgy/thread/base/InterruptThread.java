package top.ann.zhgy.thread.base;

/**
 * @author ann-zhgy
 * @version InterruptThread.class 2023-10-18 14:58
 * @since 2023-10
 */
public class InterruptThread {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("runnable");
        });
        thread.start();
        thread.interrupt();
    }
}
