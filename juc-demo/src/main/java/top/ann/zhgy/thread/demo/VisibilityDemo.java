package top.ann.zhgy.thread.demo;

/**
 * @author ann-zhgy
 * @version VisibilityDemo.class 2023-10-13 15:24
 * @since 2023-10
 */
public class VisibilityDemo {
    private static boolean stop = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("线程内循环开始，stop = " + stop);
            while (!stop) {
                System.out.println("操作");
            }
            System.out.println("线程内循环结束，stop = " + stop);
        }).start();
        Thread.sleep(2000);
        System.out.println("main 线程修改 stop 的值");
        stop = true;
        System.out.println("main 线程修改完毕，stop = " + stop);
    }
}
