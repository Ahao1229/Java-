package com.study.logback.d4_polymorphic_test;

/**
 *  USB接口 == 规范
 */
public interface USB {
    // 接入，拔出
    void connect();
    void unconnect();
}
