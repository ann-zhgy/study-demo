package top.ann.zhgy.coin.change.demo;

import top.ann.zhgy.coin.change.AbstractCoinChange;

/**
 * 贪心实现，错误解法
 *
 * @author ann-zhgy
 * @version Demo01.class 2023-04-11 19:33
 * @since 2023-04
 */
public class Demo01 extends AbstractCoinChange {

    public Demo01(int total, int[] parValue) {
        super(total, parValue);
    }

    @Override
    public int getMinCount() {
        int total = getTotal();
        int[] parValue = getParValue();
        int result = 0;
        for (int value : parValue) {
            int currCount = total / value;
            int rest = total - value * currCount;
            result += currCount;
            if (rest == 0) {
                return result;
            }
            total = rest;
        }

        return NO_RESULT_CODE;
    }
}
