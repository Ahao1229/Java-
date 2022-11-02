package com.study.d3_factory_pattern;

public class Huawei extends Computer{
    @Override
    public void start() {
        System.out.println(getName() + "开机，展示华为logo");
    }
}
