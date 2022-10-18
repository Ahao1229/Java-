# 一、缓冲流



## 1、缓冲流概述

* 缓冲流也成为高效流。之前的字节流成为原始流
* **作用：缓冲流自带缓冲区、可以提高原始字节流、字符流读写数据的性能**

> **在内存中的流程分析**

![](https://pic1.imgdb.cn/item/634e4b7116f2c2beb14de40a.jpg)

> **缓冲流类的继承关系图**

![](https://pic1.imgdb.cn/item/634e4bfd16f2c2beb14f24be.jpg)

> **缓冲流分类**

* 字节缓冲流
  * 字节缓冲输入流：BufferedInputStream
  * 字节缓冲输出流：BufferedOutputStream
* 字符缓冲流
  * 字符缓冲输入流：BufferedReader
  * 字符缓冲输出流：BufferedWriter



## 2、字节缓冲流

* BufferedInputStream 和 FileInputStream 用法相同
* BufferedOutputStream 和 FileOutputStream 用法相同

> **复制文件的代码如下**：

```java
 public static void main(String[] args) {
        try (
                // 这里面只能放置资源对象，用完自动关闭，自动调用资源对象的close方法关闭资源（即使出现异常也会做关闭操作）
                // 1、创建一个字节输入流管道与原视频沟通
                InputStream is = new FileInputStream("day09-oop-demo/src/data04.txt");
                // a. 把原始的字节输入流包装秤高级的缓冲字节输入流
                InputStream bis = new BufferedInputStream(is);

                // 2、创建一个字节输出流管道与目标文件接通
                OutputStream os = new FileOutputStream("day10-oop-demo/src/CopyData05.txt");
                // b. 把字节输出流管道包装成高级的缓冲字节输出流管道
                OutputStream bos = new BufferedOutputStream(os);
                ) {
            // 3、定义一个字节数组来转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer , 0 , len);
            }
            System.out.println("复制完成了！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
```

> **总结**

* 字节缓冲流为什么提高了操作数据的性能
  * 字节缓冲流自带8KB缓冲区
  * 可以提高原始字节流、字符流读写数据的性能

* 字节缓冲流的功能如何调用？
  * public BufferedOutputStream(OutputStream os)
  * public BufferedInputStream(InputStream is)



## 3、字节缓冲流的性能分析

> **需求分析**

![](https://pic1.imgdb.cn/item/634e541416f2c2beb1618df9.jpg)

* **==注：由于没有长视频，本次案例我用文本代替==**

> **代码：**

```java
 private static final String SRC_FILE = "day10-oop-demo/src/CopyData01.txt";
    private static final String DEST_FILE = "day10-oop-demo/src/";
    public static void main(String[] args) {
        copy01();   // 使用低级的字节流按照一个一个字节的形式复制到文件         慢的让人简直无法忍受。直接被淘汰。
        copy02();   // 使用低级的字节流按照一个一个字节数组的形式复制到文件       比较慢，但是还是可以忍受的！
        copy03();   // 使用高级的字节流按照一个一个字节的形式复制到文件         很慢，不建议使用。
        copy04();   // 使用高级的字节流按照一个一个字节数组的形式复制到文件        飞快，简直太完美了（推荐使用）
    }

    private static void copy04() {
        long startTime = System.currentTimeMillis();
        try (
                // 这里面只能放置资源对象，用完自动关闭，自动调用资源对象的close方法关闭资源（即使出现异常也会做关闭操作）
                // 1、创建一个字节输入流管道与原视频沟通
                InputStream is = new FileInputStream(SRC_FILE);
                // a. 把原始的字节输入流包装秤高级的缓冲字节输入流
                InputStream bis = new BufferedInputStream(is);
                // 2、创建一个字节输出流管道与目标文件接通
                OutputStream os = new FileOutputStream(DEST_FILE + "CopyData05.txt");
                // b. 把字节输出流管道包装成高级的缓冲字节输出流管道
                OutputStream bos = new BufferedOutputStream(os);
        ) {
            // 3、定义一个字节数组来转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer , 0 , len);
            }
            System.out.println("复制完成了！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用高级的字节流按照一个一个字节数组的形式复制到文件耗时："+ (endTime - startTime)/1000.0 + "s");

    }

    private static void copy03() {
        long startTime = System.currentTimeMillis();
        try(
                // 1、创建低级的字节输入流与源文件接通
                InputStream is = new FileInputStream(SRC_FILE);
                // a. 把原始的字节输入流包装秤高级的缓冲字节输入流
                InputStream bis = new BufferedInputStream(is);
                // 2、创建低级的字节输出流与目标文件接通
                OutputStream os = new FileOutputStream(DEST_FILE + "CopyData04.txt");
                // b. 把字节输出流管道包装成高级的缓冲字节输出流管道
                OutputStream bos = new BufferedOutputStream(os);
                ){
            // 3、定义一个变量记录每次读取的字节（一个一个字节复制）
            int b;
            while ((b = bis.read()) != -1){
                bos.write(b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用高级的字节流按照一个一个字节的形式复制到文件耗时："+ (endTime - startTime)/1000.0 + "s");

    }

    private static void copy02() {
        long startTime = System.currentTimeMillis();
        try (
                // 这里面只能放置资源对象，用完自动关闭，自动调用资源对象的close方法关闭资源（即使出现异常也会做关闭操作）
                // 1、创建一个字节输入流管道与原视频沟通
                InputStream is = new FileInputStream(SRC_FILE);

                // 2、创建一个字节输出流管道与目标文件接通
                OutputStream os = new FileOutputStream(DEST_FILE + "CopyData03.txt");

        ) {
            // 3、定义一个字节数组来转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = is.read(buffer)) != -1){
                os.write(buffer , 0 , len);
            }
            System.out.println("复制完成了！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用低级的字节流按照一个一个字节数组的形式复制到文件耗时："+ (endTime - startTime)/1000.0 + "s");

    }


    private static void copy01() {
        long startTime = System.currentTimeMillis();
        try(
                // 1、创建低级的字节输入流与源文件接通
                InputStream is = new FileInputStream(SRC_FILE);
                // 2、创建低级的字节输出流与目标文件接通
                OutputStream os = new FileOutputStream(DEST_FILE + "CopyData02.txt");
                ){
            // 3、定义一个变量记录每次读取的字节（一个一个字节复制）
            int b;
            while ((b = is.read()) != -1){
                os.write(b);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用低级的字节流按照一个一个字节的形式复制到文件耗时："+ (endTime - startTime)/1000.0 + "s");

    }
```

> **推荐使用哪种方式提高字节流读写数据的性能？**

建议使用字节缓冲输入流、字节缓冲输出流，结合字节数组的方式，目前来看是性能最优的组合。



## 4、字符缓冲流

