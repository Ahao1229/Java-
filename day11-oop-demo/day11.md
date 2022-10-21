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



# 三、Thread的常用方法

## 1、Thread常用API说明

* Thread常用方法：获取线程名称getName()、设置名称setName()、获取当前线程对象currentThread()。
* 至于Thread类提供的诸如：yield、join、interrupt、不推荐的方法stop、守护线程、线程优先级等线程的控制方法，在开发中很少使用。

> **当有很多线程在执行的时候，怎么区分这些线程？**

* 此时需要使用Thread的常用方法：getName)、setName()、
  currentThread()等。

> **Thread获取和设置线程名称**

* String getName()    获取当前线程的名称，默认线程名称是Thread-索引
* void setName(String name)    将此线程的名称更改为指定的名称，通过构造器也可以设置线程名称 

> **Thread构造器**

* public Thread(String name)   可以为当前线程指定名称
* public Thread(Runnable target)   封装Runnable对象成为线程对象
* public Thread(Runnable target String name)   封装Runnable对象成为线程对象，并指定线程名称

> **代码实现：**

- MyThread类

```java
public class MyThread extends Thread{
    public MyThread() {
    }

    public MyThread(String name) {
        // 为当前线程对象设置名称，送给父类的有参构造器初始化名称
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++ ) {
            System.out.println(Thread.currentThread().getName() + "输出" + i);
        }
    }
}
```

* 测试类

```java
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread("1号");
//        t1.setName("1号");  // set方法设置名字
        t1.start();
        System.out.println(t1.getName());

        Thread t2 = new MyThread("2号");
//        t2.setName("2号");  // set方法设置名字
        t2.start();
        System.out.println(t2.getName());

        // 哪个线程执行它，它就得到哪个线程对象（当前线程对象）
        Thread m = Thread.currentThread();
        System.out.println(m.getName());

        for (int i = 0; i < 5; i++) {
            System.out.println("main输出：" + i);
        }

    }
}

```

> **Thread类的线程休眠方法**

* public static void sleep(long time)    让当前线程休眠指定的时间后再继续执行，单位为毫秒。

> **代码实现：**

```java
public static void main(String[] args) throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("输出：" + i);
            if (i == 2){
                // 让进程休眠
                // 段子：项目经理让我加上这行代码，如果用户愿意交钱，我就注释掉
                Thread.sleep(3000);
            }
        }
    }
```

> **总结**

* Thread常用方法

|               方法名称                |                     说明                      |
| :-----------------------------------: | :-------------------------------------------: |
|           String getName()            | 获取当前线程的名称，默认线程名称是Thread-索引 |
|       void setName(String name)       |                 设置线程名称                  |
| public static Thread currentThread(): |      返回对当前正在执行的线程对象的引用       |
|  public static void sleep(long time)  |      让线程休眠指定的时间，单位为毫秒。       |
|           public void run()           |                 线程任务方法                  |
|          public void start()          |                 线程启动方法                  |

* Thread常用构造器

|                   构造器                    |                    说明                    |
| :-----------------------------------------: | :----------------------------------------: |
|         public Thread(String name)          |           可以为当前线程指定名称           |
|       public Thread(Runnable target）       |        把Runnablej对象交给线程对象         |
| public Thread(Runnable target String name） | 把Runnable对像交给线程对象，并指定线程名称 |



# 四、线程安全

## 1、线程安全问题是什么、发生的原因

* **多个线程同时操作同一个共享资源的时候可能会出现业务安全问题，称为线程安全问题。**

> **取钱模型演示**

* 需求：小明和小红是一对夫妻，他们有一个共同的账户，余额是10万元。

* 如果小明和小红同时来取钱，而且2人都要取钱10万元，可能出现什么问题呢？

![](https://pic1.imgdb.cn/item/63523a0016f2c2beb1cc93a1.jpg)

> **线程安全问题出现的原因**

* 多线程并发
* 同时访问共享资源
* 存在修改共享资源



## 2 线程安全问题案例模拟

> **案例：取钱业务**

![](https://pic1.imgdb.cn/item/63523aa716f2c2beb1cd5e55.jpg)

> **代码实现：**

* 账户类Account

```java
public class Account {
    private String cardID;
    private double money;

    public Account() {
    }

    public Account(String cardID, double money) {
        this.cardID = cardID;
        this.money = money;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 小明小红取钱
     */
    public void drawMoney(Double money) {
        // 1、先看是谁来取钱
        String name= Thread.currentThread().getName();
        // 2、判断账户是否够钱
        if (this.money >= money){
            // 2、取钱
            System.out.println(name + "取钱成功，取出：" + money);
            // 3、更新余额
            this.money -= money;
            System.out.println(name + "取钱后。剩余：" + this.money);
        }else {
            // 4、余额不足
            System.out.println(name + "来取钱，余额不足!");
        }

    }
}
```

* 取钱线程类DrawThread

```java
public class DrawThread extends Thread{
    // 接受处理的账户对象
    private Account acc;
    public DrawThread(Account acc , String name){
        super(name);
        this.acc = acc;
    }
    @Override
    public void run() {
        // 小明 小红 取钱
        acc.drawMoney(100000.0);
    }
}

```

* 测试类 ThreadDemo

```java
 public static void main(String[] args) {
        // 1、定义线程类，创建一个共享的账户对象
        Account acc = new Account("FF-521",100000);

        // 2、创建两个线程对象，代表小明小红同时进来了
        new DrawThread(acc , "小明").start();
        new DrawThread(acc , "小红").start();

    }
```

* 运行结果

![](https://pic1.imgdb.cn/item/63523f7016f2c2beb1d36655.jpg)

> **线程安全问题发生的原因是什么？**

* 多个线程同时访问同一个共享资源且存在修改该资源。



# 五、线程同步

## 1、同步思想概述

### 1.1 线程同步

* **为了解决线程安全问题**

> **取钱案例出现问题的原因**

* 多个线程同时执行，发现账户都是够钱的。

> **如何才能保证线程安全呢？**

* 让多个线程实现先后依次访问共享资源，这样就解决了安全问题



### 1.2 线程同步的核心思想

* **==加锁，==把共享资源进行上锁，每次只能一个线程进入访问完毕以后解锁，然后其他线程才能进来。**

> **图解**

* **小红先进来取走钱**

![](https://pic1.imgdb.cn/item/6352412f16f2c2beb1d5a114.jpg)

* **小红出来后，小明再进来发现余额不足**

![](https://pic1.imgdb.cn/item/6352417416f2c2beb1d5fdff.jpg)

> 线程同步解决安全问题的思想是什么？

* **==加锁：==让多个线程实现先后依次访问共享资源，这样就解决了安全问题。**



## 2、方式一：同步代码块

### 1.1 同步代码块

* **作用**：把出现线程安全问题的核心代码给上锁。
* **原理**：每次只能一个线程进入，执行完毕后自动解锁，其他线程才可以进来执行。

> **格式：**

* synchronized ( 同步锁对象 ) {

  ​		操作共享资源的代码（ 核心代码 ）

  }

> **锁对象要求**

* **理论上：锁对象只要对于当前同时执行的线程来说是同一个对象即可。**

> **代码实现：**

* 在Account对象中的取钱方法drawMoney中选中需要加锁的代码，Ctrl+Alt+T 选择第9个环绕方式**synchronized**，在括号内起一个对象名，就可以完成同步代码块的加锁

```java
public class Account {
    private String cardID;
    private double money;

    public Account() {
    }

    public Account(String cardID, double money) {
        this.cardID = cardID;
        this.money = money;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 小明小红取钱
     */
    public void drawMoney(Double money) {
        // 1、先看是谁来取钱
        String name= Thread.currentThread().getName();
        // 同步代码块
        // 小明 小红
        synchronized ("quq") {
            // 2、判断账户是否够钱
            if (this.money >= money){
                // 2、取钱
                System.out.println(name + "取钱成功，取出：" + money);
                // 3、更新余额
                this.money -= money;
                System.out.println(name + "取钱后。剩余：" + this.money);
            }else {
                // 4、余额不足
                System.out.println(name + "来取钱，余额不足!");
            }
        }


    }
}
```

* 加上同步代码块之后的运行结果为：

![](https://pic1.imgdb.cn/item/6352482616f2c2beb1df4a73.jpg)



### 2.2 同步代码块的优化

> **锁对象用任意唯一的对象好不好呢？**

* 不好，会影响其他无关线程的执行。
  * 如果有另一对夫妻小黑小白来取钱，用另个账户，但是也需要等小明小红的线程

> **锁对象的规范要求**

* 规范上：建议使用共享资源作为锁对象
* 对于**实例对象**建议使用**this**作为锁对象
* 对于**静态方法**建议使用**字节码（类名.class）**对象作为锁对象

> **代码修改：**

* 将同步代码块的对象名改为账户，使用this来调用识别当前的账户

```java
 // this = acc 共享账户
        synchronized (this) {
            // 2、判断账户是否够钱
            if (this.money >= money){
                // 2、取钱
                System.out.println(name + "取钱成功，取出：" + money);
                // 3、更新余额
                this.money -= money;
                System.out.println(name + "取钱后。剩余：" + this.money);
            }else {
                // 4、余额不足
                System.out.println(name + "来取钱，余额不足!");
            }
        }
```



### 2.3 总结

> **1、同步代码块是如何实现线程安全的？**

* 对出现问题的核心代码使用synchronized进行加锁
* 每次只能一个线程占锁进入访问

> **2、同步代码块的同步锁对象有什么要求？**

* 对于**实例对象**建议使用**this**作为锁对象
* 对于**静态方法**建议使用**字节码（类名.class）**对象作为锁对象



## 3、方式二：同步方法

### 3.1 同步方法

* 作用：把出现线程安全问题的核心方法给上锁。
* 原理：每次只能一个线程进入，执行完毕以后自动解锁，其他线程才可以进来执行。

> **格式：**

* 修饰符  **synchronized**  返回值类型  方法名称（形参列表）{

  ​			操作共享资源的代码

  }

> **代码实现：**

* 只需要给Account对象类中的取钱方法drawMoney加上synchronized修饰就可以了

```java
public synchronized void drawMoney(Double money) {
        // 1、先看是谁来取钱
        String name= Thread.currentThread().getName();
        // 2、判断账户是否够钱
        if (this.money >= money){
            // 2、取钱
            System.out.println(name + "取钱成功，取出：" + money);
            // 3、更新余额
            this.money -= money;
            System.out.println(name + "取钱后。剩余：" + this.money);
        }else {
            // 4、余额不足
            System.out.println(name + "来取钱，余额不足!");
        }
```

* 运行结果：

![](https://pic1.imgdb.cn/item/6352482616f2c2beb1df4a73.jpg)



### 3.2 同步方法的底层原理

* 同步方法其实底层也是有隐式锁对象的，只是锁的范围是整个方法代码。
* 如果方法是实例方法：同步方法默认用**this**作为的锁对象。但是代码要高度面向对象！
* 如果方法是静态方法：同步方法默认用**类名.class**作为的锁对象。

> **1、是同步代码块好还是同步方法好一点？**

* 同步代码块锁的范围更小，同步方法锁的范围更大。

* 但在实际开发中，同步方法的可读性和书写都要好一点，用的更多一些



### 3.3 总结

> **1、同步方法是如何保证线程安全的？**

* **对出现问题的核心方法使用synchronized修饰**
* **每次只能一个线程占锁进入访问**

> **2、同步方法的同步锁对象的原理？**

* **对于实例方法默认使用this作为锁对象。**
* **对于静态方法默认使用类名.classi对象作为锁对象。**



## 4、方式三：Lock锁

### 4.1 Lock锁

* 为了更清晰的表达如何加锁和释放锁，JDK5以后提供了一个新的锁对象Lock,更加灵活、方便。
* Lock实现提供比使用synchronized方法和语句可以获得更广泛的锁定操作。
* Lock是接口不能直接实例化，这里采用它的实现类ReentrantLock来构建Lock锁对象。

|       方法名称        |          说明          |
| :-------------------: | :--------------------: |
| public ReentranLock() | 获取Lock锁的实验类对象 |



### 4.2 Lock 的 API

|   方法名称    |  说明  |
| :-----------: | :----: |
|  void lock()  | 获得锁 |
| void unlock() | 释放锁 |



### 4.3 idea实现代码

* **为了防止加锁之后出现异常导致死锁，加上try{...}finally{...}使其无论是否出现异常都会释放锁**

```java
public class Account {
    private String cardID;
    private double money;
    // 加上final修饰后：锁对象是唯一不可替换的
    private final Lock lock = new ReentrantLock();
    public Account() {
    }

    public Account(String cardID, double money) {
        this.cardID = cardID;
        this.money = money;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 小明小红取钱
     */
    public void drawMoney(Double money) {
        // 1、先看是谁来取钱
        String name= Thread.currentThread().getName();
        lock.lock();
        try {
            // 2、判断账户是否够钱
            if (this.money >= money){
                // 2、取钱
                System.out.println(name + "取钱成功，取出：" + money);
                // 3、更新余额
                this.money -= money;
                System.out.println(name + "取钱后。剩余：" + this.money);
            }else {
                // 4、余额不足
                System.out.println(name + "来取钱，余额不足!");
            }
        } finally {
            lock.unlock(); // 解锁
        }

    }
}
```

* 运行结果：

![](https://pic1.imgdb.cn/item/6352482616f2c2beb1df4a73.jpg)



# 六、线程通信（了解）

## 1、什么是线程通信、如何实现？

* **所谓线程通信就是线程间相互发送数据，线程通信通常通过共享一个数据的方式实现。**
* **线程间会根据共享数据的情况决定自己该怎么做，以及通知其他线程怎么做。**



## 2、线程通信常见模型

* **生产者与消费者模型：生产者线程负责生产数据，消费者线程负责消费数据。**
* **要求：生产者线程生产完数据后，唤醒消费者，然后等待自己；消费者消费完该数据后，唤醒生产者，然后等待自己。**
  * 就是生产者干完等消费者，消费者干完等生产者



## 3、线程通信案例模拟

### 3.1 案例分析

* 假如有这样一个场景，小明和小红有三个爸爸，爸爸们负责存钱，小明和小红负责取钱，必须一存、一取。（存完必须花完才能再存）

![](https://pic1.imgdb.cn/item/635252fd16f2c2beb1ec18a3.jpg)

* **线程通信的前提：**线程通信通常是在多个线程操作同一个共享资源的时候需要进行通信，且要保证线程安全。

> **Object类的等待和唤醒方法：**

|     方法名称     |                             说明                             |
| :--------------: | :----------------------------------------------------------: |
|   void wait()    | 让当前线程等待并释放所占锁，直到另一个线程调用notify()方法或notifyAll()方法 |
|  void notify()   |                    唤醒正在等待的单个线程                    |
| void notifyAll() |                    唤醒正在等待的所有线程                    |

* **==注意：==**
  * 上述方法应该使用同步锁对象进行调用



### 3.2 代码实现

> **ThreadDemo测试类：**

```java
public static void main(String[] args) {
        // 目标：了解线程通信的流程。
        // 使用3个爸爸存钱(生产者)2个孩子取钱(消费者)模拟线程通信思想（一存10w 一取10w）

        // 1、创建账户对象，代表五个人共同操作账户
        Account acc = new Account("FFFSS-32" , 0);

        // 2、创建2个取钱线程代表小明和小红
        new DrawThread(acc , "小明").start();
        new DrawThread(acc , "小红").start();

        // 3、创建3个存钱线程代表：亲爹，干爹，养爹
        new DepositThread(acc ,  "亲爹").start();
        new DepositThread(acc ,  "干爹").start();
        new DepositThread(acc ,  "养爹").start();

    }
```



> **DrawThread孩子线程类：**

```java
public class DrawThread extends Thread{
    private Account acc;

    public DrawThread(Account acc , String name){
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        while (true) {
            // 小明 小红 不断取钱
            acc.drawMoney(100000);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```



> **DepositThread父亲线程类：**

```java
public class DepositThread extends Thread{
    private Account acc;

    public DepositThread(Account acc , String name){
        super(name);
        this.acc = acc;
    }

    @Override
    public void run() {
        while (true) {
            // 亲爹 干爹 养爹     不断存钱
            acc.deposit(100000);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```



> **Account账户对象类：**

```java
public class Account {
    private String cardID;
    private double money;

    public Account() {
    }

    public Account(String cardID, double money) {
        this.cardID = cardID;
        this.money = money;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    /**
     * 小明和小红 ： 取钱
     */
    public synchronized void drawMoney(double money) {
        try {
            String name = Thread.currentThread().getName();
            if (this.money >= money){
                // 钱够，可取
                System.out.println(name + "来取钱:" + money + "成功!");
                this.money -= money;
                System.out.println(name+ "取钱结束后，余额为：" + this.money);
                // 没钱了
                this.notifyAll(); // 唤醒所有线程
                this.wait(); // 锁对象，让当前线程进入等待！
            }else {
                // 钱不够不可取
                // 唤醒别人，等待自己
                this.notifyAll(); // 唤醒所有线程
                this.wait(); // 锁对象，让当前线程进入等待！
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *  亲爹 干爹 养爹
     */
    public synchronized void deposit(double money) {
        try {
            String name = Thread.currentThread().getName();
            if (this.money == 0){
                // 没钱了，存钱吧
                this.money += money;
                System.out.println(name + "存钱" + money + "成功！存钱后余额为：" + this.money);
                // 有钱了，唤醒别人，等待自己
                this.notifyAll(); // 唤醒所有线程
                this.wait(); // 当前进程进行等待
            }else {
                // 有钱不存钱
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
```



> **运行结果：**

![](https://pic1.imgdb.cn/item/63525b5e16f2c2beb1f7b18d.jpg)



### 3.3 总结

> 线程通信的三个常见方法

|     方法名称     |                             说明                             |
| :--------------: | :----------------------------------------------------------: |
|   void wait()    | 让当前线程等待并释放所占锁，直到另一个线程调用notify()方法或notifyAll()方法 |
|  void notify()   |                    唤醒正在等待的单个线程                    |
| void notifyAll() |                    唤醒正在等待的所有线程                    |

* **==注意：==**
  * 上述方法应该使用同步锁对象进行调用



# 七、线程池（重点）

## 1、线程池概述

### 1.1 什么是线程池？

* 线程池就是一个可以复用线程的技术。



### 1.2 不使用线程池的问题

* 如果**用户每发起一个请求，后台就创建一个新线程来处理，下次新任务来了又要创建新线程，==而创建新线程的开销是很大的==，这样会严重影响系统的性能。**



### 1.3 线程池工作原理

* 比如说线程池里规定有三个线程，前三个任务用完三个线程之后，第四个重新用第一个，以此类推，达到线程池中核心线程复用的目的。

![](https://pic1.imgdb.cn/item/63525d6716f2c2beb1fa6ba0.jpg)



## 2、线程池实现的API、参数说明

