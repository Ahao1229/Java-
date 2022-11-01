package com.study.d9_proxy;

public class Kun implements Ctrl{
    private String name;

    public Kun(String name) {
        this.name = name;
    }

    @Override
    public void sing() {
        System.out.println("全民制作人们大家好，我是练习时长两年半的个人练习生" + name);
    }

    @Override
    public void jump() {
        System.out.println("喜欢唱、跳、Rap、篮球，Music~");
    }

    @Override
    public void rap() {
        System.out.println("鸡你太美，baby，鸡你实在是太美，baby");
        System.out.println("在今后的节目中,我还准备了很多我自己作词、作曲、编舞的原创作品,期待的话请多多为我投票吧!!");
    }

    @Override
    public void basketball() {
        System.out.println("你干嘛~~~~哎呦~~~~~");
    }
}
