package com.study.d10_proxy2;

public class UserServiceImpl implements UserService{
    @Override
    public String login(String loginName, String passWord) {

        String rs = "登录名称和密码错误";
        if ("admin".equals(loginName) && "123456".equals(passWord)){
            rs = "登录成功";
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public void deleteUser() {
        try {
            System.out.println("您正在删除用户数据中。。。");
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String selectUser() {
        String rs = "查询了10000个用户数据~~~";
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return rs;
    }

    @Override
    public void deleteById(int id) {
        try {
            System.out.println("根据用户的id：" + id + "删除了它");
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
