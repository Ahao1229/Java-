package com.study.logback.d6_innerclass;


/**
 *  外部类
 */
public class Outer {
    /**
     *  成员内部类：不能加static修饰 属于外部类对象的
     */
    class Inner{
       private String name;
       private int age;




        public Inner() {
        }

        public Inner(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void show(){
            System.out.println("名称：" + name);
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

        }
    }

