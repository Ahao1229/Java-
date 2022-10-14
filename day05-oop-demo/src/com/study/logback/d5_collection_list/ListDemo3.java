package com.study.logback.d5_collection_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo3 {
    public static void main(String[] args) {
        // LinkedList可以完成队列机构和栈结构（双链表）
        // 栈
        LinkedList<String> stack = new LinkedList<>();
        stack.push("第一颗子弹");
        stack.push("第二颗子弹");
        stack.push("第三颗子弹");
        stack.push("第四颗子弹");
        System.out.println(stack);
        // 出栈
        System.out.println(stack.getFirst());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);

        // 队列
        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("1");
        queue.offerFirst("2");  // offerLast
        queue.addLast("3");
        queue.addLast("4");
        // 出队
        System.out.println(queue.getFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);



    }
}
