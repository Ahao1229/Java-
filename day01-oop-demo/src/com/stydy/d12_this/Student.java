package com.stydy.d12_this;

public class Student {
    private String name;
    private String schoolName;

    public Student() {
    }

    /**
        如果学生不填写学校，默认这个对象的学校是四方
     */
    public Student(String name){
        // 借用本类兄弟构造器
        this(name,"四方");
    }
    public Student(String name, String schoolName) {
        //super();// 必须先初始化父亲，在初始化自己。  必须在第一行
        this.name = name;
        this.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
