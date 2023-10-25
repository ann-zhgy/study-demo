package top.ann.zhgy.coin.change.demo;

import top.ann.zhgy.coin.change.AbstractCoinChange;

/**
 * 贪心实现（递归），添加回溯
 *
 * @author ann-zhgy
 * @version Demo02.class 2023-04-14 14:34
 * @since 2023-04
 */
public class Demo02 extends AbstractCoinChange {
    public Demo02(int total, int[] parValue) {
        super(total, parValue);
    }

    @Override
    public int getMinCount() {
        return getMinCount(getTotal(), 0);
    }

    private int getMinCount(int total, int parValueIndex) {
        int parValueLength = getParValue().length;
        if (parValueLength == parValueIndex) {
            return NO_RESULT_CODE;
        }
        int currCoinValue = getParValue()[parValueIndex];
        int currCoinValueMaxCount = total / currCoinValue;
        for (int count = currCoinValueMaxCount; count >= 0; count--) {
            int rest = total - currCoinValue * count;
            // 如果余额为 0，说明组合完毕了，直接返回
            if (rest == 0) {
                return count;
            }
            // 使用剩余的面额尝试组合
            int restCount = getMinCount(rest, parValueIndex + 1);
            // 如果没有返回 NO_RESULT_CODE，直接返回
            if (restCount != NO_RESULT_CODE) {
                return count + restCount;
            }
        }
        return NO_RESULT_CODE;
    }
}
