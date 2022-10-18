# 一、字符集

* 计算机底层不可以直接存储字符的。计算机中底层只能存储二进制(0、1)
* 二进制是可以转换成十进制的

![](https://pic1.imgdb.cn/item/6348b18116f2c2beb12b5f45.jpg)

**结论：计算机底层可以表示十进制编号。计算机可以给人类字符进行编号存储，这套编号规则就是字符集。**



## 1、ASCII字符集

* ASCII(American Standard Code for Information Interchange,美国信息交换标准代码)：包括了数字、英文、符号。
* **ASCII使用1个字节存储一个字符，一个字节是8位**，总共可以表示128个字符信息，对于英文，数字来说是够用的。

## 2、GBK

* window系统默认的码表。兼容ASCII码表，也包含了几万个汉字，并支持繁体汉字以及部分日韩文字。
* 注意：**GBK是中国的码表，一个中文以两个字节的形式存储。**但不包含世界上所有国家的文字

## 3、Unicode码表

* unicode(又称统一码、万国码、单一码)是计算机科学领域里的一项业界字符编码标准。

* 容纳世界上大多数国家的所有常见文字和符号。

* 由于Unicode会先通过UTF-8,UTF-16,以及UTF-32的编码成二进制后再存储到计算机，其中最为常见的就是UTF-8。

==注意：==

* ==Unicode是万国码，以UTF-8编码后一个中文一般以三个字节的形式存储。==

* ==UTF-8也要兼容ASCII编码表。==

* ==技术人员都应该使用UTF-8的字符集编码。==

* ==编码前和编码后的字符集需要一致，否则会出现中文乱码。==

![](https://pic1.imgdb.cn/item/6348b3ce16f2c2beb12eb87b.jpg)



## 4、总结

![](https://pic1.imgdb.cn/item/6348cc3216f2c2beb14fec92.jpg)

## 5、代码

```java
public static void main(String[] args) throws UnsupportedEncodingException {
        // 1、编码：把文字转换成字节（使用指定的编码）
        String name = "abc我爱你中国";
        byte[] bytes = name.getBytes(); // 以当前代码默认字符集进行编码(UTF-8)
        System.out.println(Arrays.toString(bytes));

        String arr = "我爱你";
        byte[] bytes1 = arr.getBytes();
        System.out.println(Arrays.toString(bytes1));

        String arr1 = "我爱你老婆";
        byte[] bytes2 = arr1.getBytes("GBK");   // 指定GBK编码
        System.out.println(Arrays.toString(bytes2));


        // 2、解码：把字节转换成对应的中文形式（编码前 和 编码后的字符集必须一致，否则乱码）
        String rs = new String(bytes);
        System.out.println(rs); // 默认UTF-8

        String rs1 = new String(arr);
        System.out.println(rs1);

        String rs2 = new String(arr1);
        System.out.println(rs2);
    }
```



# 二、IO流

## 1、IO流概述

### 1.1 什么是IO流

IO流也称为输入、输出流，就是用来读写数据的。

* I表示intput,是数据从硬盘文件读入到内存的过程，称之输入，负责读。

* O表示output,是内存程序的数据从内存到写出到硬盘文件的过程，称之输出，负责写。

![](https://pic1.imgdb.cn/item/6348d40c16f2c2beb15bb329.jpg)



### 1.2 IO流的分类

* ==按流的方向分为：输入流和输出流==
* ==按流中的数据最小单位分为：字节流（更适合音视频文件，可以操作所有类型文件）和字符流（只能操作纯文本文件）==

> **流的四大类**

* 字节输入流：以内存为基准，来自磁盘文件/网络中的数据**以字节的形式读入到内存中**去的流称为字节输入流。

* 字节输出流：以内存为基准，把内存中的数据**以字节写出到磁盘文件或者网络中**去的流称为字节输出流。

* 字符输入流：以内存为基准，来自磁盘文件/网络中的数据**以字符的形式读入到内存中**去的流称为字符输入流。

* 字符输出流：以内存为基准，把内存中的数据**以字符写出到磁盘文件或者网络介质中**去的流称为字符输出流。

![](https://pic1.imgdb.cn/item/6348d50c16f2c2beb15d2073.jpg)

> **四类流都是抽象类，需要使用子类操作**

![](https://pic1.imgdb.cn/item/6348d5b216f2c2beb15e06e1.jpg)

### 1.3 总结

![](https://pic1.imgdb.cn/item/6348d62c16f2c2beb15ea69b.jpg)



## 2、字节流的使用

### 2.1 文件输入流

* **文件输入流：每次读取一个字节**

![](https://pic1.imgdb.cn/item/6348d6e316f2c2beb15faa06.jpg)

> **文件字节输入流FileInputStream**

* 作用 ：以内存为基准，把磁盘文件中的数据以字节的形式读取到内存中去。
  * 构造器
    * public FileInputStream（File file）创建字节输入流管道与源文件对象接通
    * public FilelnputStream(String pathname) 创建字节输入流管道与源文件路径接通

* * 方法

    * public int read（）每次读取一个字节返回，如果字节已经没有可读的返回-1
    * public int read(byte[]buffer) 每次读取一个字节数组返回，如果字节已经没有可读的返回-1

    ```java
     public static void main(String[] args) throws Exception {
            // 1、创建一个文件字节输入流管道与源文件接通
    //        InputStream is = new FileInputStream(new File("day09-oop-demo/src/data.txt"));
            // 简化写法
            InputStream is = new FileInputStream("day09-oop-demo/src/data.txt");
    
            // 2、读取字节返回（每次一个字节太麻烦，使用循环改进）
            // 定义一个变量记录每次读取的字节
            int b;
            while ((b = is.read()) != -1){
                System.out.print((char) b);
            }
            // 这个方法无法读取中文
    
        }
    ```

    

* 每次读入一个字节数组的数据**（依然无法阻止乱码）**

  ```Java
   public static void main(String[] args) throws Exception {
          // 1、创建一个文件字节流入管道与源文件接通
          InputStream is = new FileInputStream("day09-oop-demo/src/com/study/data02.txt");
          // 2、定义一个字节数组，用来读取字节数据
          byte[] buffer = new byte[3]; // 后续开发一般都是1024 1KB
          int len ; // 记录每次读取的字节数
          // 3、改进使用循环，每次读取一个字节数组
          while ((len = is.read(buffer)) != -1){
              //用多少取多少
              System.out.print(new String(buffer , 0 , len));
          }
      }
  ```

   

* **一次性读取完文件的全部字节就可以保证输出不乱码，但如果文件过大，字节数组可能引起内存溢出**

  * 方式一：自己定义一个字节数组与文件的大小一样大，然后使用读取字节数组的方法，一次性读取完成

  ```java
   // 1、创建一个文件字节输入流管道与源文件接通
          File f  = new File("day09-oop-demo/src/data03.txt");
          InputStream is = new FileInputStream(f);
  
   // 2、定义一个数组与文件的大小一样大
  //        byte[] buffer = new byte[(int) f.length()];
  //        int len = is.read(buffer);
  //        System.out.println("读取了多少个字节:" + len);
  //        System.out.println("文件大小:" + f.length());
  //        System.out.println(new String(buffer));
  
          //读取全部字节数组 （API）
          byte[] buffer = is.readAllBytes();
          System.out.println(new String(buffer));
  ```
  
  
  
  * ​	

> **总结**

* 读取一个字节的api是 **public int read()**	但是**性能慢，无法读取中文**

* 读取一个字节数组的api是 public int read（） **读取性能得到了提升，但依然无法阻止乱码**

* **字节输入流读取中文内容不乱码：**

  **一次读完全部字节有两种方法：定义与文件一样大的字节数组读取（如果文件过大可能引起内存溢出），或者使用官方API。****
  



### 2.2 文件字节输出流

> **1、字节输入写数据的方法有三种**

public void write(int a)写一个字节出去

public void write(byte[]buffer) 写一个字节数组出去

public void write(byte[]buffer , int pos,int len) 写一个字节数组的一部分出去。

> **2、字节输出流如何实现数据追加**

public FileOutputStream(String filepath , boolean append)创建字节输出流管道与源文件路径接通，可追加数据

> **3、字节输出流如何实现写出去的数据能换行**

os.write("\r\n".getBytes())

> **4.如何让写出去的数据能成功生效**

- flush() 刷新数据
- close() 方法是关闭流，关闭包含刷新，关闭后流不可以继续使用了。

```java
public static void main(String[] args) throws Exception {
        // 1、创建一个文件字节输出流管道与目标文件接通
       // OutputStream os = new FileOutputStream("day09-oop-demo/src/data04.txt"); // 覆盖管道，先清空之前的数据，写数据进去
        OutputStream os = new FileOutputStream("day09-oop-demo/src/data04.txt" , true); // 追加管道，写之前不会清空写
        // 2、写数据出去
        // a. public void write(int a): 写一个字节
        os.write('a');
        os.write(98);
        os.write("\r\n".getBytes(StandardCharsets.UTF_8)); // 换行
//        os.write('李'); // 中文三个字节，所以会乱码

        // 写数据必须刷新数据，不然可能没有同步到文件中，刷新后流可以接着使用
        os.flush();

        // b. public void write(byte[] buffer):写一个字节数组
        byte[] buffer = {'a', 97, 98, 99};
        os.write(buffer);
        os.write("\r\n".getBytes(StandardCharsets.UTF_8)); // 换行
        
        byte[] buffer2 = "我是中国人".getBytes(StandardCharsets.UTF_8); // 可以编码传写
        os.write(buffer2);
        os.write("\r\n".getBytes(StandardCharsets.UTF_8)); // 换行
        
        // c. public void write(byte[] buffer , int pos , int len):写一个字节数组的一部分出去
        byte[] buffer3 = {'a', 97,98,99,100,101,102,103};
        os.write(buffer3, 2 , 2);
        os.write("\r\n".getBytes(StandardCharsets.UTF_8)); // 换行

        
        // 释放资源，用完关掉节省内存空间（包含刷新）,关闭后流不可以使用
        os.close();
    }
```



### 2.3 文件拷贝

> **案例分析：**

![](https://pic1.imgdb.cn/item/634e040316f2c2beb1a40648.jpg)

> **案例代码：**

```java
 public static void main(String[] args){
        try {
            // 1、创建一个字节输入流管道与原视频沟通
            InputStream is = new FileInputStream("day09-oop-demo/src/AnotherHardcoreGame 2022-04-09 15-05-20.mp4");

            // 2、创建一个字节输出流管道与目标文件接通
            OutputStream os = new FileOutputStream("day09-oop-demo/src/CopyAnotherHardCoreGame.mp4");

            // 3、定义一个字节数组来转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = is.read(buffer)) != -1){
                os.write(buffer , 0 , len);
            }
            System.out.println("复制完成了！");

            // 4、关闭流
            is.close();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
```

> **内存分析**

![](https://pic1.imgdb.cn/item/634e06e316f2c2beb1a79ed1.jpg)

> **为什么字节流适合做一切文件数据的拷贝？**

* 任何文件的底层都是字节，拷贝是一字不漏的转移字节，只要前后文件格式、编码一致没有任何问题。



## 3、资源释放的方式

### 3.1 try-catch-finally

* **finally**：在异常处理时提供finally块来执行所有清除操作，比如说IO流中的释放资源
* **==特点：被finally控制的语句最终一定会执行，除非JVM退出(即使代码中存在return结束，也一定会执行finally)==**
* 异常处理标准格式：**try..catch..finally**

> **try-catch-finally格式：**

![](https://pic1.imgdb.cn/item/634e0ce116f2c2beb1afd18a.jpg)

> **try-catch-finally案例代码：**

```java
 public static void main(String[] args){
        // 将管道定义为全局，否则在finally中无法调用关闭
        InputStream is = null;
        OutputStream os = null;
        try {
            // 1、创建一个字节输入流管道与原视频沟通
           is = new FileInputStream("day09-oop-demo/src/data04.txt");

            // 2、创建一个字节输出流管道与目标文件接通
           os = new FileOutputStream("day09-oop-demo/src/CopyData05.txt");

            // 3、定义一个字节数组来转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = is.read(buffer)) != -1){
                os.write(buffer , 0 , len);
            }
//            System.out.println(10 / 0);
            System.out.println("复制完成了！");


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 无论代码是否正常结束，都会执行这里，除非JVM挂掉
            System.out.println("-----------finally-----------");
            // 4、关闭流
            try {
                // 防止管道使用前出现异常，导致关闭管道抛出空指针异常
                if (os != null){
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                // 防止管道使用前出现异常，导致关闭管道抛出空指针异常
                if (is != null){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println(test(10,2));
    }

    public static int test (int a , int b){
        try {
            int c = a / b;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }finally {
            // 这里的代码即使上面已经return,也必须执行完这里才可以结束
            // 开发中不建议在这里加return,如果加了，返回的永远是这里的数据了，这样会出问题！
            return 100;
        }
    }
```

**运行结果为：**

​	复制完成了！

​	-----------finally-----------

​	100

> **try-catch-finally的作用**

* finally代码块是最终一定要执行的，可以在代码执行完毕
  的最后用于释放资源。
* 除非System.exit(0)，挂掉虚拟机，就是删库跑路，千万别做！



### 3.2 改进方法 try-catch-resource

![](https://pic1.imgdb.cn/item/634e165116f2c2beb1bd2348.jpg)

> **JDK7 实现代码：**

```java
 public static void main(String[] args){
        try (
                // 这里面只能放置资源对象，用完自动关闭，自动调用资源对象的close方法关闭资源（即使出现异常也会做关闭操作）
                // 1、创建一个字节输入流管道与原视频沟通
               InputStream is = new FileInputStream("day09-oop-demo/src/data04.txt");
                // 2、创建一个字节输出流管道与目标文件接通
                OutputStream os = new FileOutputStream("day09-oop-demo/src/CopyData05.txt");
                ) {

            // 3、定义一个字节数组来转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = is.read(buffer)) != -1){
                os.write(buffer , 0 , len);
            }
//            System.out.println(10 / 0);
            System.out.println("复制完成了！");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

> **JDK9 实现代码：（了解）**

```java
public static void main(String[] args) throws Exception {
        // 1、创建一个字节输入流管道与原视频沟通
        InputStream is = new FileInputStream("day09-oop-demo/src/data04.txt");
        // 2、创建一个字节输出流管道与目标文件接通
        OutputStream os = new FileOutputStream("day09-oop-demo/src/CopyData05.txt");
        try (is ; os) {

            // 3、定义一个字节数组来转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = is.read(buffer)) != -1){
                os.write(buffer , 0 , len);
            }
//            System.out.println(10 / 0);
            System.out.println("复制完成了！");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

> **注意事项：**

* **JDK7 以及 JDK9 的()中只能放置资源对象，否则报错**
* **什么是资源呢？**
  * **资源都是实现了Closeable / AutoCloseable接口的类对象**
  * **例如：**
    * **public abstract class InputStream implements Closeable{}**
    * **public abstract class OutputStream implements Closeable , Flushable{}**

> **try-catch-resource的作用**

* 自动释放资源、代码简洁



## 4、字符流的使用

> **为什么要使用字符流**

* **字节流读取中文输出会乱码、也存在内存溢出的可能**
* **字符流更适合读取中文，因为最小单位是按照单个字符读取****

![](https://pic1.imgdb.cn/item/634e196b16f2c2beb1c1ae94.jpg)



### 4.1 文件字符输入流Reader（一次读取一个字符）

* **每次读取字符的api是：public int read()  每次读取一个字符返回，如果字节已经没有可读的返回-1**

*  **读取中文字符不会出现乱码（如果代码和文件编码一致）**
* **性能较慢**

> **代码：**

```java
public static void main(String[] args) throws Exception{
        // 目标：每次读取一个字符。
        // 1、创建一个字符输入楼管道与源文件接通
        Reader fr = new FileReader("day09-oop-demo/src/CopyData05.txt");

        // 2、使用循环读取字符返回，没有可读的字符是会返回-1；
        int code;
        while ((code = fr.read()) != -1){
            System.out.print((char) code);
        }
    }
```



### 4.2 文件字符输入流FileReader（一次读取一个字符数组）

* **作用：以内存为基准，把磁盘文件中的数据以字符的形式读取到内存中去。**

* **public int read(char[] buffer)每次读取一个字符数组，返回读取的字符数，如果字符已经没有可读的返回-1**

* **性能得到提升**

> **代码：**

```java
public static void main(String[] args) throws Exception{
        // 目标：每次读取一个字符。
        // 1、创建一个字符输入楼管道与源文件接通
        Reader fr = new FileReader("day09-oop-demo/src/Data06.txt");

        // 2、用循环，每次读取一个字符数组的数据
        char[] buffer = new char[1024]; // 1K字符
        int len;
        while ((len = fr.read(buffer)) != -1){
            String rs = new String(buffer , 0 ,len);
            System.out.println(rs);
        }

    }
```



### 4.3 文件字符输出流FileWriter

* 字符输出流写数据的方法有：
  * void write( int c ) 写一个字符
  * void write( char[]cbuf ) 写入一个字符数组
  * void write( char[]cbuf , int off , int len ) 写入字符数组的一部分
  * void write( String str ) 写一个字符串
  * void write( String str , int off , int len ) 写一个字符串的一部
  * void write( int c ) 写一个字符

* public FileWriter(String filepath,boolean append) 创建字符输出流管道与源文件路径接通可追加数据

* 字符输出流实现写出去的数据能换行：fw.write(r\n")

* 字符输出流写完数据后必须做什么？
  * flush()刷新数据。
  * close()方法是关闭流，关闭包含刷新，关闭后流不可以继续使用了。

* 字节流、字符流如何选择使用？
  * 字节流适合做一切文件数据的拷贝（音视频，文本）
  * 字节流不适合读取中文内容输出
  * 字符流适合做文本文件的操作（读，写）
