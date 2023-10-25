package top.ann.zhgy.coin.change.demo;

import top.ann.zhgy.coin.change.AbstractCoinChange;

import java.util.Arrays;

/**
 * 迭代实现
 *
 * @author ann-zhgy
 * @version Demo04.class 2023-04-18 10:48
 * @since 2023-04
 */
public class Demo04 extends AbstractCoinChange {
    public Demo04(int total, int[] parValue) {
        super(total, parValue);
    }

    @Override
    public int getMinCount() {
        int[] result = new int[getTotal() + 1];
        Arrays.fill(result, NO_RESULT_CODE);
        result[0] = 0;
        for (int i = 1; i <= getTotal(); i++) {
            for (int value : getParValue()) {
                if (i - value < 0) {
                    continue;
                }
                if (result[i - value] == NO_RESULT_CODE) {
                    continue;
                }
                result[i] = result[i - value] + 1;
                break;
            }
        }
        return result[getTotal()];
    }
}
