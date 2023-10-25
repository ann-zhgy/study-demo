package top.ann.zhgy.fibonacci;

import lombok.AccessLevel;
import lombok.Getter;

/**
 * 斐波那契
 *
 * @author ann-zhgy
 * @version Fibonacci.class 2023-04-17 15:01
 * @since 2023-04
 */
public abstract class AbstractFibonacci {
    @Getter(AccessLevel.PROTECTED)
    private int count;

    /**
     * 获取计算结果
     * @param n 第几个斐波那契数
     * @return int
     */
    public int getFibonacciResult(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        startStatisticsCalcCount();
        preCalcHandle(n);
        return calcResult(n);
    }

    /**
     * 获取计算的次数
     * @return int
     */
    public abstract int calcCount();

    /**
     * 具体的计算的逻辑
     * @param n 第几个斐波那契数
     * @return int
     */
    protected abstract int calcResult(int n);

    /**
     * 计算前处理
     * @param n 第几个斐波那契数
     */
    protected void preCalcHandle(int n) {}

    /**
     * 计算次数自增
     */
    protected final void countAutoincrementOne() {
        count++;
    }

    /**
     * 初始化计算次数，开始统计
     */
    private void startStatisticsCalcCount() {
        this.count = 0;
    }
}
