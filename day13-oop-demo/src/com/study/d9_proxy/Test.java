package com.study.d9_proxy;

public class Test {
    public static void main(String[] args) {
        // 目标：学习开发出一个动态代理的对象出来，理解动态代理的执行流程
        // 1、创建一个对象（蔡徐坤）,对象的类必须实现接口
        Kun kun = new Kun("蔡徐坤");
        // 2、为蔡徐坤对象，生成一个代理对象iKun
        Ctrl ikun = iKun.getProxy(kun);
        ikun.sing(); // 走代理
        ikun.jump();
        ikun.rap();
        ikun.basketball();
    }
}
