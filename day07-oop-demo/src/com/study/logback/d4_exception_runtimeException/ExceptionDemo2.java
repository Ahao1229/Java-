package com.study.logback.d4_exception_runtimeException;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        try {
            checkAge(34);
        } catch (istudyAgeIlleagalException e) {

        }
    }
    public static void checkAge(int age) throws istudyAgeIlleagalException{
        if (age < 0 || age > 200){
            throw new istudyAgeIlleagalException(age + "is illeagal!");
        }else {
            System.out.println("年龄合法，推荐其购买");
        }
    }
}
