package top.ann.zhgy.fibonacci.demo;

import top.ann.zhgy.fibonacci.AbstractFibonacci;

import java.util.Arrays;

/**
 * 带有备忘录的递归斐波那契
 *
 * @author ann-zhgy
 * @version RecursionFibonacciWithMemorandum.class 2023-04-17 19:44
 * @since 2023-04
 */
public class RecursionFibonacciWithMemorandum extends AbstractFibonacci {
    private int[] cache = {};

    @Override
    public int calcResult(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (cache[n - 1] != -1) {
            return cache[n - 1];
        }
        countAutoincrementOne();
        int fibonacciN = calcResult(n - 2) + calcResult(n - 1);
        cache[n - 1] = fibonacciN;
        return fibonacciN;
    }

    @Override
    public int calcCount() {
        return getCount();
    }

    @Override
    protected void preCalcHandle(int n) {
        cache = new int[n];
        Arrays.fill(cache, -1);
    }
}
