package com.stydy.d11_extends_constructor;

public class People {
    private String nama;
    private int age;

    public People() {
    }

    public People(String nama, int age) {
        this.nama = nama;
        this.age = age;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
