package com.study.logback.d13_interface_jdk8;

public interface SportManInter {
    /**
     * 1、JDK8开始：默认方法(实例方法)
     * -- 必须default修饰，默认public修饰
     * -- 默认方法，我们不能创建对象，这个方法只能过继给实现类，有实现类的对象调用
     */
    public default void run(){
        System.out.println("跑的很快");
        go();
    }

    /**
     *  2、静态方法
     *  必须使用static修饰，默认public修饰
     */
    public static void inAddr(){
        System.out.println("我们都在学习Java新增方法的语法，他是Java源码自己会用到的~~~");
    }

    /**
     *  3、私有方法 (实例方法)
     *  -- JDK1.9开始支持的
     *  -- 必须在接口内部才能被访问
     */
    private void go(){
        System.out.println("开始跑~~~");
    }

    class PingPongMan implements SportManInter{

    }
    class Test{
        public static void main(String[] args) {
            PingPongMan p = new PingPongMan();
            p.run();

            SportManInter.inAddr();
            // PingPongMan.inAddr();
        }
    }
}
