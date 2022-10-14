package com.study.logback.d4_polymorphic_test;

public class Computer {
    private String name;
    public void start(){
        System.out.println(name + "开机了");
    }
    /**
     *  提供安装USB设备的入口
     */

    public void installUSB(USB usb){
        // 多态
        usb.connect();
        if (usb instanceof KeyBoard){
           KeyBoard k = (KeyBoard) usb;
           k.keyDown();
        }else if(usb instanceof Mouse){
            Mouse m = (Mouse) usb;
            m.dbClick();
        }

        usb.unconnect();
    }

    public Computer() {
    }

    public Computer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
