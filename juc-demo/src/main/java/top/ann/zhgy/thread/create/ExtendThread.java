package top.ann.zhgy.thread.create;

/**
 * @author ann-zhgy
 * @version ExtendThread.class 2023-10-17 18:15
 * @since 2023-10
 */
public class ExtendThread {
    public static void main(String[] args) {
        new ThreadDemo().start();
    }

    static class ThreadDemo extends Thread {
        @Override
        public void run() {
            System.out.println("继承 Thread 类");
        }
    }
}
