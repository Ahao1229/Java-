package com.study.logback.d14_bigdecimal;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        System.out.println(0.09 + 0.01);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301 / 100);

        System.out.println("-----------------");
        double a = 0.1;
        double b = 0.2;
        double c = a + b;
        System.out.println(c);
        System.out.println("-----------------");

        // 包装浮点型数据成为大数据对象 BigDecimal
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        // BigDecimal c1 = a1.add(b1); // 加
        // BigDecimal c1 = a1.subtract(b1); // 减
        // BigDecimal c1 = a1.multiply(b1); // 乘
        BigDecimal c1 = a1.divide(b1);
        System.out.println(c1);
        // 目的：精度计算后返回double类型
        double rs = c1.doubleValue();
        System.out.println(rs);

        System.out.println("-----------------");

        // 注意事项：BigDecimal 一定要精度运算
        BigDecimal a2 = BigDecimal.valueOf(10.0);
        BigDecimal b2 = BigDecimal.valueOf(3.0);
        // BigDecimal c2 = a2.divide(b2); // 3.333333333333333 运行完会报错
        /**
         * 参数一：除数       参数二：保留几位小数位数        参数三：舍入模式
         */
        BigDecimal c2 = a2.divide(b2, 2, BigDecimal.ROUND_HALF_UP); // a2/b2 结果保留两位小数，四舍五入
        System.out.println(c2);

    }
}
