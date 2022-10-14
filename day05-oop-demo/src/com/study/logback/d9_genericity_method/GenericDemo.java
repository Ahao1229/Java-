package com.study.logback.d9_genericity_method;

public class GenericDemo {
    public static void main(String[] args) {
        String[] names = {"小璐" , "蓉蓉" , "小啊"};
        printArray(names);

        Integer[] ages = {10,20,30};
        printArray(ages);
    }

    private static<T> void printArray(T[] arr) {
        if (arr != null){
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0 ; i < arr.length ; i++) {
                sb.append(arr[i]).append(i == arr.length - 1 ? "" : ",");
            }
            sb.append("]");
            System.out.println(sb);

        }else {
            System.out.println(arr);
        }

    }
}
