package top.ann.zhgy.coin.change.demo;

import top.ann.zhgy.coin.change.AbstractCoinChange;

import java.util.Arrays;

/**
 * 递归添加备忘录
 *
 * @author ann-zhgy
 * @version Demo03.class 2023-04-17 20:04
 * @since 2023-04
 */
public class Demo03 extends AbstractCoinChange {
    private final int[] cache;

    public Demo03(int total, int[] parValue) {
        super(total, parValue);
        cache = new int[total];
        Arrays.fill(cache, Integer.MIN_VALUE);
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
                cache[total - 1] = count;
                return count;
            }
            if (cache[rest - 1] != Integer.MIN_VALUE) {
                return cache[rest - 1];
            }
            // 使用剩余的面额尝试组合
            int restCount = getMinCount(rest, parValueIndex + 1);
            // 如果没有返回 NO_RESULT_CODE，直接返回
            if (restCount != NO_RESULT_CODE) {
                int result = count + restCount;
                cache[rest - 1] = result;
                return result;
            }
        }
        return NO_RESULT_CODE;
    }
}
