package com.study.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  目标：快速搭建LogBack日志框架  记录程序的执行情况到文件中。
 */
public class Test {
    // 创建LogBack的日志对象，代表了日志技术

    public static final Logger logger = LoggerFactory.getLogger("Test.class");
    public static void main(String[] args) {
        try {
            logger.debug("main方法开始执行了~~~");
            logger.info("我开始记录第二行日志，我要开始做除法");
            int a = 10;
            int b = 2;
            logger.trace("a=" + a);
            logger.trace("b=" + b);
            System.out.println(a / b);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("功能出现异常，" + e);
        }


    }
}

