package top.ann.zhgy.coin.change;

import lombok.AccessLevel;
import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ann-zhgy
 * @version AbstractCoinChange.class 2023-04-11 19:48
 * @since 2023-04
 */
@Getter(AccessLevel.PROTECTED)
public abstract class AbstractCoinChange {
    protected static final int NO_RESULT_CODE = -1;

    /**
     * 总值
     */
    private final int total;

    /**
     * 面值
     */
    private final int[] parValue;

    public AbstractCoinChange(int total, int[] parValue) {
        this.total = total;
        this.parValue = Arrays.stream(parValue)
                .boxed()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public abstract int getMinCount();
}
