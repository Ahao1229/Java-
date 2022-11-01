package com.study.d8_annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 *  目标：完成注解的解析
 */

public class AnnotationDemo3 {
    @Test
    public void parseClass() throws Exception {
        // a.先得到类对象
        Class c = BookStore.class;
        Method m = c.getDeclaredMethod("test");
        // b.判断这个类上面是否存在这个注解
        if (c.isAnnotationPresent(Book1.class)){
            // c.获取该注解对象
//            Annotation book = c.getDeclaredAnnotation(Book1.class);
            Book1 book = (Book1) c.getDeclaredAnnotation(Book1.class);
            System.out.println(book.value());
            System.out.println(book.price());
            System.out.println(Arrays.toString(book.authors()));
        }
        System.out.println("-------------------------------------------");
        if (m.isAnnotationPresent(Book1.class)){
            // c.获取该注解对象
            Book1 book2 = (Book1) m.getDeclaredAnnotation(Book1.class);
            System.out.println(book2.value());
            System.out.println(book2.price());
            System.out.println(Arrays.toString(book2.authors()));
        }
    }
}
