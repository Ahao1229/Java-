package com.stydy.d9_extends_override;

public class Text {
    public static void main(String[] args) {
        // 目标：认识方法重写。
        NewPhone hw = new NewPhone();
        hw.call();
        hw.sendMsg();
    }
}

/**
 * 旧手机
 */
class Phone{
    public void call(){
        System.out.println("打电话~");
    }
    public void sendMsg(){
        System.out.println("发短信");
    }
    public static void test(){

    }
}

/**
 * 新手机
 */
class NewPhone extends Phone{
    //重写的方法
    // 注意：重写方法的名称和形参列表必须和被重写的一样
    // 私有的方法不能被重写
    // 子类不能重写父类的静态方法
    @Override // 重写校验注解,重写不对会报错;提高程序可读性
    public void call(){
        super.call();
        System.out.println("开始视频通话~~");
    }
    //重写的方法
    @Override
    public void sendMsg(){
        super.sendMsg();
        System.out.println("发送有趣的图片");
    }
//    @Override
//    public void test(){
//    错误的
//    }
}