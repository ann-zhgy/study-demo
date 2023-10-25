package top.ann.zhgy.thread.demo;

/**
 * @author ann-zhgy
 * @version OrderDemo.class 2023-10-13 15:50
 * @since 2023-10
 */
public class ReorderDemo {
    private static int a;
    private static int b;
    private static int x;
    private static int y;

    public static void main(String[] args) throws InterruptedException {
        int count = 0;
        while (true) {
            a = 0; b = 0;
            x = 0; y = 0;
            Thread thread1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread thread2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            count++;
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            if (x == 0 && y == 0) {
                System.out.println("经过 " + count + " 次循环之后，x = 0, y = 0");
                break;
            }
        }
        System.out.println("exit");
    }
}
