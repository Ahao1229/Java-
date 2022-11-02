package com.study.d3_factory_pattern;

public class Mac extends Computer{
    @Override
    public void start() {
        System.out.println(getName() + "优雅启动，并展示苹果logo");
    }
}
