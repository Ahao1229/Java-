package com.study.d10_proxy2;

public interface UserService {
    String login(String loginName, String passWord);
    void deleteUser();
    String selectUser();
    void deleteById(int id);
}
