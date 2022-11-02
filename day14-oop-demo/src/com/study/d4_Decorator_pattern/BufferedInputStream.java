package com.study.d4_Decorator_pattern;

/**
 * 装饰类：继承InputStream 拓展原始类的功能
 */
public class BufferedInputStream extends InputStream{
    private InputStream is;
    public BufferedInputStream(InputStream is){
        this.is = is;
    }
    @Override
    public int read() {
        System.out.println("提供8kb缓冲区，提高读数据性能！！！！");
        return is.read();
    }

    @Override
    public int read(byte[] buffer) {
        System.out.println("提供8kb缓冲区，提高读数据性能！！！！！");
        return is.read(buffer);
    }
}
