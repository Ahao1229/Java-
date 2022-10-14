package com.study.logback.d11_genericity_limit;

import java.util.ArrayList;

public class Genericity {
    public static void main(String[] args) {
        ArrayList<BMW> bmws = new ArrayList<>();
        bmws.add(new BMW());
        bmws.add(new BMW());
        bmws.add(new BMW());
        go(bmws);


        ArrayList<BENZ> benzs = new ArrayList<>();
        benzs.add(new BENZ());
        benzs.add(new BENZ());
        benzs.add(new BENZ());
        go(benzs);
    }

    /**
     * 所有车比赛
     */
    public static void go(ArrayList<? extends  Car> cars){

    }


    static class BMW extends Car{

}
    static class BENZ extends Car{

    }
    static class Car{

    }

}


