package com.study.logback.d5_enum;

/**
    枚举类
 */
public enum Season {
    // 枚举类第一行必须罗列枚举类对象名称，建议全部大写
    SPRING,SUMMER,AUTUMN,WINTER;
}
/*
反编译之后的枚举
public final class Season extends java.lang.Enum<Season> {
  // 枚举类是最终类，不可以被继承；  构造器是私有的，对外不能创建对象
  // 第一行默认罗列枚举对象的名称；  相当于多例模式。

  public static final Season SPRING;
  public static final Season SUMMER;
  public static final Season AUTUMN;
  public static final Season WINTER;
  public static Season[] values();
  public static Season valueOf(java.lang.String); // 继承的java.lang.String
  static {};
}
 */