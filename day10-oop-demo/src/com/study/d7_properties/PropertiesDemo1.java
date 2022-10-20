package com.study.d7_properties;

import java.io.FileWriter;
import java.util.Properties;

public class PropertiesDemo1 {
    public static void main(String[] args) throws Exception {
        // 需求：使用Properties把键值对信息存入到属性文件中去
        Properties properties = new Properties();
        properties.setProperty("admin", "123456");
        properties.setProperty("Ahao", "011229");
        properties.setProperty("feifei", "haowife");
        System.out.println(properties);

        /**
         *  参数一：保存管道，字符输出流管道
         *  参数二：保存心得
         */
        properties.store(new FileWriter("day10-oop-demo/src/user.properties"), "注释");

    }
}
