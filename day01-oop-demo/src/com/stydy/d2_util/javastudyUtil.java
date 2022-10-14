package com.stydy.d2_util;

import java.util.Random;

/**
    工具类
 */
public class javastudyUtil {
    /**
        由于工具类无需创建对象，所以把其构造器私有化会显得很专业
     */
    private javastudyUtil(){

    }

    /**
        静态方法
     */
    public static String creatVerifyCode(int n){
        // 开发一个验证码
        String code = "";
        String data = "qwertyuiopasdfghjklzxcvbnm1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            int index = r.nextInt(data.length());
            code += data.charAt(index);
        }
        System.out.println(code);
        return code;
    }
}
