package top.ann.zhgy.fibonacci.demo;

import top.ann.zhgy.fibonacci.AbstractFibonacci;

/**
 * 循环计算斐波那契
 *
 * @author ann-zhgy
 * @version LoopFibonacci.class 2023-04-17 19:33
 * @since 2023-04
 */
public class LoopFibonacci extends AbstractFibonacci {
    @Override
    public int calcResult(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        int fib1 = 0, fib2 = 1, temp = 0;
        for (int i = 3; i <= n; i++) {
            countAutoincrementOne();
            temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;
        }
        return temp;
    }

    @Override
    public int calcCount() {
        return getCount();
    }
}
