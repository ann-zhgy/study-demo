package top.ann.zhgy.thread.demo;

import java.util.Vector;

/**
 * @author ann-zhgy
 * @version VectorDemo.class 2023-10-16 16:17
 * @since 2023-10
 */
public class VectorDemo {
    public static void main(String[] args) {
        final Vector<Integer> vector = new Vector<>();
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println("vector 的第 " + i + " 个元素: " + vector.get(i));
                }
            }).start();
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    System.out.println("删除 vector 的第 " + i + " 个元素");
                    vector.remove(i);
                }
            }).start();
            while (Thread.activeCount() > 20) {
                return;
            }
        }
    }
}
