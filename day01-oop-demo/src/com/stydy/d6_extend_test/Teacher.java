package com.stydy.d6_extend_test;

public class Teacher extends People{
    private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    /**
     独有行为：发布问题
     */
    public void release(){
        System.out.println(getName() + "发布了问题：学校太破了");
    }
}
