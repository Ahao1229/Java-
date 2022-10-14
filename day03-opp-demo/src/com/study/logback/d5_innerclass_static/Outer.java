package com.study.logback.d5_innerclass_static;

public class Outer {
    public static int a = 100;
    private String hobby;
    /**
     *  学习静态成员内部类
     */
    public static class Inner{
        private String name;
        private int age;
        private String schoolName;

        public Inner() {
        }

        public Inner(String name, int age, String schoolName) {
            this.name = name;
            this.age = age;
            this.schoolName = schoolName;
        }

        public void show(){
            System.out.println("名称：" + name);
            System.out.println(a);

            // 通过对象访问外部类的实例成员
            Outer o = new Outer();
            System.out.println(o.hobby);

            // System.out.println(hobby);  // 直接访问报错
        }







        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSchoolName() {
            return schoolName;
        }

        public void setSchoolName(String schoolName) {
            this.schoolName = schoolName;
        }
    }
}
