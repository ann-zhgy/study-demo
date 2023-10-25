package top.ann.zhgy;

import top.ann.zhgy.coin.change.AbstractCoinChange;
import top.ann.zhgy.coin.change.demo.Demo01;
import top.ann.zhgy.coin.change.demo.Demo02;
import top.ann.zhgy.coin.change.demo.Demo03;
import top.ann.zhgy.coin.change.demo.Demo04;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int total = 289746 + new Random().nextInt(7000000);
        System.out.println("total = " + total);
        int[] parValue = {100, 50, 20, 10, 5, 2, 1};
        List<AbstractCoinChange> coinChangeList = Arrays.asList(new Demo01(total, parValue), new Demo02(total, parValue), new Demo03(total, parValue), new Demo04(total, parValue));
        coinChangeList.forEach(coinChange -> {
            System.out.println("------" + coinChange.getClass().getName() + "------");
            long start = System.currentTimeMillis();
            int minCount = -1;
            for (int i = 10000000; i > 0; i--) {
                minCount = coinChange.getMinCount();
            }
            System.out.println("result = " + minCount);
            System.out.println("time = " + (System.currentTimeMillis() - start));
            System.runFinalization();
        });
//        List<AbstractFibonacci> fibonacciList = Arrays.asList(new LoopFibonacci(), new RecursionFibonacci(), new RecursionFibonacciWithMemorandum());
//        fibonacciList.forEach(fibonacci -> {
//            System.out.println("------" + fibonacci.getClass().getName() + "------");
//            System.out.println("result = " + fibonacci.getFibonacciResult(21));
//            System.out.println("calcCount = " + fibonacci.calcCount());
//        });
    }
}
