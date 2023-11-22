/*
 * Meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package cn.ann.test.bean;

import java.math.BigDecimal;
import javax.validation.constraints.PositiveOrZero;
import lombok.Data;

/**
 * @author wb_zhanggaoyu@meituan.com
 * @version Person.class 2023-11-22 11:01
 * @since 2023-11-22 11:01
 */
@Data
public class Person {
    private String name;
    @PositiveOrZero
    private BigDecimal age;
}
