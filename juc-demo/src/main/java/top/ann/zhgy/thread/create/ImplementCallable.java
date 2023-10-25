package top.ann.zhgy.thread.create;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ann-zhgy
 * @version ImplementCallable.class 2023-10-17 18:11
 * @since 2023-10
 */
public class ImplementCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> "实现 Callable 接口";
        FutureTask<String> futureTask = new FutureTask<>(task);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
