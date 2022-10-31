package com.study.d1_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试类
 */
public class TestUserService {
    /**
     * 测试方法
     * 注意点：
     *          1、必须公开的，无参数，无返回值的方法
     *          2、测试方法必须使用@Test注解标记
     */
    @Test
    public void testLoginName(){
        UserService userService = new UserService();
        String rs = userService.loginName("admin","123456");

        // 进行预期结果的正确性测试：断言。
        Assertions.assertEquals("登录成功", rs, "您的程序出现BUG");

    }

    @Test
    public void testSelectNames(){
        UserService userService = new UserService();
        userService.selectNames();

    }
}
