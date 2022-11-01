package com.study.d8_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 一直活着，在运行阶段这个注解也不消失
@Target({ElementType.METHOD})   // 元注解
public @interface MyTest {

}
