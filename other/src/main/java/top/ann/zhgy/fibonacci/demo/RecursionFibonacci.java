package top.ann.zhgy.fibonacci.demo;

import top.ann.zhgy.fibonacci.AbstractFibonacci;

/**
 * 递归计算斐波那契
 *
 * @author ann-zhgy
 * @version RecursionFibonacci.class 2023-04-17 19:35
 * @since 2023-04
 */
public class RecursionFibonacci extends AbstractFibonacci {
    @Override
    public int calcResult(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        countAutoincrementOne();
        return calcResult(n - 2) + calcResult(n - 1);
    }

    @Override
    public int calcCount() {
        return getCount();
    }
}
