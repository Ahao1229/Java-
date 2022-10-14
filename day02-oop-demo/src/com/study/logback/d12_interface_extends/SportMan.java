package com.study.logback.d12_interface_extends;

import com.study.logback.d11_interface_implements.Law;

/**
 *  接口多继承：一个接口可以继承多个接口
 */

public interface SportMan extends Law,People {
    void run();
    void competition();
}
