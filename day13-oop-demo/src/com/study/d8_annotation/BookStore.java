package com.study.d8_annotation;

@Book1(value = "《三体》",price = 99.9,authors = {"刘慈欣"})
public class BookStore {

    @Book1(value = "球状闪电",price = 59.9,authors = {"刘慈欣01"})
    public void test(){

    }
}
