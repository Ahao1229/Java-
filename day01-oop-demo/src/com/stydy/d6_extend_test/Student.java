package com.stydy.d6_extend_test;

public class Student extends People{
    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    /**
        独有行为：填写反馈信息
     */
    public void writeInfo(){
        System.out.println(getName() + "写下了：学习语法很开心");
    }
}
