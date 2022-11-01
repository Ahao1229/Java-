package com.study.d8_annotation;

/**
 *  目标：学会自定义注解，掌握其定义格式和语法
 */
@MyBook(name="《三体》",authors = {"刘慈欣"},price = 66.6)
public class AnnotationDemo1 {
//    @Book(value = "/delete")
//    @Book("/delete")
    @Book(value = "/delete",price = 23.5)
    public static void main(String[] args) {

    }
}
