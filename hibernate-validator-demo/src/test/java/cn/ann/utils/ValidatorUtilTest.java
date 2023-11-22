/*
 * Meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package cn.ann.utils;

import cn.ann.test.bean.Person;
import cn.ann.util.ValidatorUtils;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.jupiter.api.Test;

/**
 * validator util 测试
 *
 * @author wb_zhanggaoyu@meituan.com
 * @version ValidatorUtilTest.class 2023-11-22 11:00
 * @since 2023-11-22
 */
public class ValidatorUtilTest {
    @Test
    public void validatorTest() {
        Person person = new Person();
        person.setAge(BigDecimal.valueOf(1.00));
        ValidatorUtils.validate(person);
    }

    @Test
    public void optionalTest() {
        Person person = new Person();
        person.setAge(BigDecimal.valueOf(1.00));
        System.out.println(Optional.ofNullable(person).map(Person::getAge).orElse(null));
        person = null;
        System.out.println(Optional.ofNullable(person).map(Person::getAge).orElse(null));
    }
}
