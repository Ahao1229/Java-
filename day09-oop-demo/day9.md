# 字符集

* 计算机底层不可以直接存储字符的。计算机中底层只能存储二进制(0、1)
* 二进制是可以转换成十进制的

![](https://pic1.imgdb.cn/item/6348b18116f2c2beb12b5f45.jpg)

**结论：计算机底层可以表示十进制编号。计算机可以给人类字符进行编号存储，这套编号规则就是字符集。**



## ASCII字符集

* ASCII(American Standard Code for Information Interchange,美国信息交换标准代码)：包括了数字、英文、符号。
* **ASCII使用1个字节存储一个字符，一个字节是8位**，总共可以表示128个字符信息，对于英文，数字来说是够用的。

## GBK

* window系统默认的码表。兼容ASCII码表，也包含了几万个汉字，并支持繁体汉字以及部分日韩文字。
* 注意：**GBK是中国的码表，一个中文以两个字节的形式存储。**但不包含世界上所有国家的文字

## Unicode码表

* unicode(又称统一码、万国码、单一码)是计算机科学领域里的一项业界字符编码标准。

* 容纳世界上大多数国家的所有常见文字和符号。

* 由于Unicode会先通过UTF-8,UTF-16,以及UTF-32的编码成二进制后再存储到计算机，其中最为常见的就是UTF-8。

==注意：==

* ==Unicode是万国码，以UTF-8编码后一个中文一般以三个字节的形式存储。==

* ==UTF-8也要兼容ASCII编码表。==

* ==技术人员都应该使用UTF-8的字符集编码。==

* ==编码前和编码后的字符集需要一致，否则会出现中文乱码。==

![](https://pic1.imgdb.cn/item/6348b3ce16f2c2beb12eb87b.jpg)



## 总结

![](https://pic1.imgdb.cn/item/6348cc3216f2c2beb14fec92.jpg)

## 代码

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



# IO流

## IO流概述

### 什么是IO流

IO流也称为输入、输出流，就是用来读写数据的。

* I表示intput,是数据从硬盘文件读入到内存的过程，称之输入，负责读。

* O表示output,是内存程序的数据从内存到写出到硬盘文件的过程，称之输出，负责写。

![](https://pic1.imgdb.cn/item/6348d40c16f2c2beb15bb329.jpg)



### IO流的分类

* ==按流的方向分为：输入流和输出流==
* ==按流中的数据最小单位分为：字节流（更适合音视频文件，可以操作所有类型文件）和字符流（只能操作纯文本文件）==

> 流的四大类

* 字节输入流：以内存为基准，来自磁盘文件/网络中的数据**以字节的形式读入到内存中**去的流称为字节输入流。

* 字节输出流：以内存为基准，把内存中的数据**以字节写出到磁盘文件或者网络中**去的流称为字节输出流。

* 字符输入流：以内存为基准，来自磁盘文件/网络中的数据**以字符的形式读入到内存中**去的流称为字符输入流。

* 字符输出流：以内存为基准，把内存中的数据**以字符写出到磁盘文件或者网络介质中**去的流称为字符输出流。

![](https://pic1.imgdb.cn/item/6348d50c16f2c2beb15d2073.jpg)

> 四类流都是抽象类，需要使用子类操作

![](https://pic1.imgdb.cn/item/6348d5b216f2c2beb15e06e1.jpg)

### 总结

![](https://pic1.imgdb.cn/item/6348d62c16f2c2beb15ea69b.jpg)



## 字节流的使用

### 文件输入流：每次读取一个字节

![](https://pic1.imgdb.cn/item/6348d6e316f2c2beb15faa06.jpg)

> 文件字节输入流FileInputStream

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

    













### 总结

* 读取一个字节的api是 **public int read()**	但是**性能慢，无法读取中文**

  
