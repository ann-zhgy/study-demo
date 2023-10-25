package top.ann.zhgy.thread.create;

/**
 * @author ann-zhgy
 * @version ImplementRunnable.class 2023-10-17 18:09
 * @since 2023-10
 */
public class ImplementRunnable {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("实现 Runnable 接口");
        new Thread(task).start();
    }
}
