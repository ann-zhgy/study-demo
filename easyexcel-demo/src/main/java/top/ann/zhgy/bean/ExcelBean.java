/*
 * Meituan.com Inc.
 * Copyright (c) 2010-2023 All Rights Reserved.
 */
package top.ann.zhgy.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * excel bean
 *
 * @author wb_zhanggaoyu@meituan.com
 * @version ExcelBean.class 2023-11-20 14:39
 * @since 2023-11-20
 */
@Data
public class ExcelBean {
    @ExcelProperty("id")
    private String id;
    @ExcelProperty("material_id")
    private String material_id;
    @ExcelProperty("material_name")
    private String material_name;
    @ExcelProperty("big_category")
    private String big_category;
    @ExcelProperty("mid_category")
    private String mid_category;
    @ExcelProperty("sub_category")
    private String sub_category;
    @ExcelProperty("计数项:unit")
    private String unit;
    @ExcelProperty("收入确认单")
    private String submitOrder;
    @ExcelProperty("商品类型")
    private String goodsType;
}
