package com.study.d10_proxy2;

public class Test {
    public static void main(String[] args) {
        // 目标：掌握使用动态代理解决问题，理解使用动态代理的优势
        UserService userService = ProxyUtil.getProxy(new UserServiceImpl());
        System.out.println(userService.login("admin", "123456"));
        System.out.println(userService.selectUser());
        userService.deleteUser();
    }
}
