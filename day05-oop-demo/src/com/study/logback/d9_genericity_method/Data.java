package com.study.logback.d9_genericity_method;

public interface Data<E>{
    void add(E e);
    void delete(int id);
    void update(E e);
    E queryById(int id);
}
