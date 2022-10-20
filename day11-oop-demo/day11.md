# 一、线程

## 1、概述

### 1.1 什么是线程

* 线程(thread)是一个程序内部的一条执行路径。
* 我们之前启动程序执行后，main方法的执行其实就是一条单独的执行路径。
* 程序中如果只有一条执行路径，那么这个程序就是单线程的程序

### 1.2多线程是什么

* 多线程是指从软硬件上实现多条执行流程的技术。

> **多线程用在哪里，有什么好处？**

* 12306买票，多个人买就是多线程
* 百度网盘同上传或者下载多个文件也是多线程
* 再例如：消息通信、淘宝、京东系统都离不开多线程技术。

### 1.3 多线程需要学会什么

* 多线程的创建：如何在程序中实现多线程，有哪些方式，各自有什么优缺点。
* Thread类的常用方法：线程的代表是Thread类，Thread提供了哪些线程的操作给我们呢？
* 线程安全、线程同步：多个线程同时访问一个共享的数据的时候会出现问题，如何去解决？
* 线程通信、线程池：线程与线程间需要配合完成一些事情。线程池是一种线程优化方案，可以用一种更好的方式使用多线程。



# 二、多线程的创建

## 1、方式一：继承Thread类

### 1.1 Thread类

* Java是通过java.lang.Thread类来代表线程的。
* 按照面向对象的思想，Thread类应该提供了实现多线程的方式。

 

### 1.2 多线程的实现方案一：继承Thread类

① 定义一个子类MyThread继承线程类java.lang.Thread, 重写run（）方法

② 创建MyThread类的对象

③ 调用线程对象的start() 方法启动线程（启动后执行run方法的）



### 1.3 方式一的优缺点

* 优点：编码简单
* 缺点：线程类已经继承Thread,无法继承其他类，不利于扩展。



### 1.4 idea执行代码

```java
public class ThreadDemo1 {
    public static void main(String[] args) {
        // 3、new 一个新线程对象
        Thread t = new MyThread();
        // 4、调用start方法启动线程（执行的还是run方法）
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("主线程执行输出：" + i);
        }

    }
}

/**
 *  1、定义一个线程类继承Thread类
 */
class MyThread extends Thread{
    /**
     *  2、重写run方法，里面是定义线程以后要干啥
     */
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程执行输出：" + i);
        }
    }
}
```



### 1.5 注意事项：

> **为什么不直接调用了run方法，而是调用start,启动线程**

* 直接调用run方法会当成普通方法执行，此时相当于还是单线程执行。
* 只有调用start方法才是启动一个新的线程执行。

> **不要把主线程任务放在子线程之前。**

* 这样主线程一直是先跑完的，相当于是一个单线程的效果了。



### 1.6 总结

> 1、方式一是如何实现多线程的？

* 继承Thread类
* 重写run方法
* 创建线程对象
* 调用start()方法启动。

> 2、优缺点是什么？

* 优点：编码简单
* 缺点：存在单继承的局限性，线程类继承Thread后，不能继承其他类，不便于扩展。



## 2、方式二：实现Runnable接口

### 2.1 多线程的实现方案二：实现Runnable接口

① 定义一个线程任务类MyRunnable实现Runnable接口，重写run()方法

② 创建MyRunnable任务对象

③ 把MyRunnable任务对象交给Thread处理。

④ 调用线程对象的start()方法启动线程



### 2.2 Thread的构造器

* public Thread( String name )   可以为当前线程指定名称
* public Thread( Runnable target )   封装Runnable对象成为线程对象
* public Thread(Runnable target String name )   封装Runnable对象成为线程对象，并指定线程名称



### 2.3 idea执行代码

```java
public class TreadDemo2 {
    public static void main(String[] args) {
        // 3、创建一个任务对象
        Runnable target = new MyRunnable();
        // 4、把任务对象交给Thread处理
        Thread t = new Thread(target);
        // 5、启动线程
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程执行输出：" + i);
        }
    }
}


/**
 *  1、定义UI个线程任务猎，实现Runnable接口
 */
class MyRunnable implements Runnable{
    /**
     *  2、重写run方法，定义线程的执行任务
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("子线程执行输出：" + i);
        }
    }
}
```



### 2.4 方式二的优缺点

* 优点：线程任务类只是实现接口，可以继续继承类和实现接口，扩展性强。
* 缺点：编程多一层对象包装，如果线程有执行结果是不可以直接返回的。



### 2.5 总结

> **1、第二种方式是如何创建线程的？**

* 定义一个线程任务类MyRunnable实现Runnable接口，重写run()方法
* 创建MyRunnable对象
* 把MyRunnable任务对象交给Thread线程对象处理。
* 调用线程对象的start()方法启动线程

> **2、第二种方式的优缺点**

* 优点：线程任务类只是实现了Runnale接口，可以继续继承和实现
* 缺点：如果线程有执行结果是不能直接返回的。



## 3、方式二：使用匿名内部类的形式实现

### 3.1 步骤

① 可以创建Runnable的匿名内部类对象。

② 交给Thread处理。

③ 调用线程对象的start0启动线程。



### 3.2 idea执行代码

```java
 public static void main(String[] args) {
        // 3、创建一个任务对象
        Runnable target = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程执行输出：" + i);
                }
            }
        };
        // 4、把任务对象交给Thread处理
        Thread t = new Thread(target);
        // 5、启动线程
        t.start();

        // 简化一：
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("子线程111执行输出：" + i);
                }
            }
        }).start();

        // 简化二：
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("子线程222执行输出：" + i);
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println("主线程执行输出：" + i);
        }
    }
```



## 4、 JDK 5.0 新增：实现Callable

### 4.1 前两种线程的共同问题

**1、前2种线程创建方式都存在一个问题：**

* 他们重写的run方法均不能直接返回结果。
* 不适合需要返回线程执行结果的业务场景。

**2、怎么解决这个问题呢？**

* JDK5.0提供了Callable和FutureTask来实现。



### 4.2 利用Callable、FutureTask接口实现

* 1、得到任务对象
  * ① 定义类实现Callable接口，重写call方法，封装要做的事情
  * ② 用FutureTask把Callable对象封装成线程任务对象
* 2、把线程任务对象交给Thread处理
* 3、调用Thread的start方法启动线程，执行任务
* 4、线程执行完毕后、通过FutureTask的get方法去获取任务执行的结果。 



### 4.3 FutureTask的API

* public FutureTask<>(Callable call)   把Callable对象封装成FutureTask对象。
* public V get()throws Exception   获取线程执行call方法返回的结果。



### 4.4 idea执行代码

```java
public class TreadDemo3 {
    public static void main(String[] args) {
        // 3、创建Callable任务对象
        Callable<String> call = new MyCallable(100);
        // 4、把Callable任务对象  封装（交给）  FutureTask对象
        // FutureTask 对象的作用1：是Runnable的对象（实现了Runnable接口），可以交给Thread了
        // FutureTask 对象的作用2：可以在线程执行完毕之后调用其get方法得到线程执行完成的结果
        FutureTask<String> f1 = new FutureTask<>(call);
        // 5、交给线程处理
        Thread t1 = new Thread(f1);
        // 6、启动线程
        t1.start();

        Callable<String> call2 = new MyCallable(200);
        FutureTask<String> f2 = new FutureTask<>(call2);
        Thread t2 = new Thread(f2);
        t2.start();

        try {
            // 如果f1任务没有执行完毕，这里的代码会等待，直到线程1跑完才提取结果
            String rs1 = f1.get();
            System.out.println("第一个结果：" + rs1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            // 如果f1任务没有执行完毕，这里的代码会等待，直到线程2跑完才提取结果
            String rs2 = f2.get();
            System.out.println("第二个结果：" + rs2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 1、定义一个任务类 实现Callable接口 应该申明线程任务执行完毕后的结果数据类型
     */
    static class MyCallable implements Callable<String> {
        private int n;

        public MyCallable(int n) {
            this.n = n;
        }

        /**
         * 2、重写call方法
         */
        @Override
        public String call() throws Exception {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                sum += i;
            }
            return "子线程执行的结果是：" + sum;
        }
    }
}
```



### 4.5 方法三的优缺点

* **优点：**
  * **线程任务类只是实现接口，可以继续继承类和实现接口，扩展性强。**
  * **可以在线程执行完毕后去获取线程执行的结果。**
* **缺点：编码复杂一些。**



### 4.6 总结

> **三种方式的比较**

|     **方式**     |                           **优点**                           |                        **缺点**                        |
| :--------------: | :----------------------------------------------------------: | :----------------------------------------------------: |
|   继承Thread类   |          编程比较简单，可以直接使用Thread类中的方法          | 扩展性较差，不能再继承其他的类，不能返回线程执行的结果 |
| 实现Runnable接口 |        扩展性强，实现该接口的同时还可以继承其他的类。        |          编程相对复杂，不能返回线程执行的结果          |
| 实现Callable接口 | 扩展性强，实现该接口的同时还可以继承其他的类。可以得到线程执行的结果 |                      编程相对复杂                      |

