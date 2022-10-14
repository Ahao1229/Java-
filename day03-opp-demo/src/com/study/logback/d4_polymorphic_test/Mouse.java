package com.study.logback.d4_polymorphic_test;

public class Mouse implements USB{
    private String name;

    public Mouse() {
    }

    public Mouse(String name) {
        this.name = name;
    }

    /**
     *  独有功能
     */
    public void dbClick(){
        System.out.println(name + "长按一键三连");
    }


    @Override
    public void connect() {
        System.out.println(name + "成功连接电脑");
    }

    @Override
    public void unconnect() {
        System.out.println(name + "已从电脑拔出");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
