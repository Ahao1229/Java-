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

### 4.1 字符缓冲输入流BufferedReader

*  作用：提高字符输入流读取数据的性能，除此之外多了按照行读取数据的功能。

> **字符缓冲流新增功能**

public String readLine()   ：读取一行数据返回，如果读取设有完毕，无行可读返回null

> **使用字符缓冲流按行读取数据**

* 经典代码：
  * 不会乱码
  * 不需要做字节数组桶
  * 很多时候需要按行读

```java
 public static void main(String[] args) {
        try (
                // 1、创建一个字符输入楼管道与源文件接通
                Reader fr = new FileReader("day10-oop-demo/src/CopyData05.txt");
                // a. 把地接的字符输入流包装成高级的缓冲字符输入流
                BufferedReader br = new BufferedReader(fr);
                ) {
            // 2、用循环，独有方法每次读取一行
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```



### 4.2 字符缓冲输出流BufferedWriter

* 作用：提高字符输出流写取数据的性能，除此之外多了换行功能

> **字符缓冲输出流新增功能**

public void newLine() 	  换行操作

> **字符缓冲输出流的使用**

* 使用与字符输出流FileWriter使用一致
* 只是之前的换行可以直接调用newLine()方法实现

```java
public static void main(String[] args) throws Exception{
        // 目标：每次读取一个字符。
        // 1、创建一个字符输入楼管道与源文件接通
        // Writer fw = new FileWriter("day09-oop-demo/src/out07.txt");// 覆盖管道，每次启动都会清空文件之前的数据
        Writer fw = new FileWriter("day10-oop-demo/src/out06.txt" , true);// 追加管道，每次启动都会清空文件之前的数据
        BufferedWriter bw = new BufferedWriter(fw);


        // a. public void write(int c):写一个字符出去
        bw.write(98);
        bw.write('a');
        bw.write('李'); // 字符，不会出错
        bw.newLine(); // 换行

        // b. public void write(String c): 写一个字符串出去
        bw.write("abc我是中国人");
        bw.newLine(); // 换行

        // c. public void write(char[] buffer): 写一个字符数组出去
        char[] chars = "abc我是中国人".toCharArray();
        bw.write(chars);
        bw.newLine(); // 换行

        // d. public void write(String c , int pos ,int len): 写字符串的一部分出去
        bw.write("abc我是中国人",0,3);
        bw.write("\r\n"); // 换行

        // e. public void write(char[] buffer , int pos ,int len): 写字符数组的一部分出去
        bw.write(chars,3,5);
        bw.newLine(); // 换行

        bw.flush(); // 刷新
        bw.close(); // 关闭包含刷新
    }
```



### 4.3 总结

> **1.字符缓冲流为什么提高了操作数据的性能？**

* 字符缓冲流自带8K缓冲区
* 可以提高原始字符流读写数据的性能

> **2.字符缓冲流的功能如何使用？**

* public BufferedReader(Reader r)
* 性能提升了，多了readLine0按照行读取的功能
* public BufferedWriter(Writer w)
* 性能提升了，多了newLine()换行的功能



### 4.4 案例

> **需求分析**

![](https://pic1.imgdb.cn/item/6350b2bd16f2c2beb1784fd5.jpg)

> **注意事项**

在Colleactions.sort的排序中，如果是重写方法用索引排序的的时候，文本里不能有空行，所有空行需要删掉，否则会报字符串截取下标越界；

> 代码：

```java
 public static void main(String[] args) {
        try (
                // 1、创建缓冲字符输入流接通管道与源文件接通
                BufferedReader br = new BufferedReader(new FileReader("day10-oop-demo/src/csb.txt"));
                // 5、定义缓冲字符输出管道与目标文件接通
                BufferedWriter bw = new BufferedWriter(new FileWriter("day10-oop-demo/src/new.txt"));
                ){

            // 2、定义一个List集合存储每行内容
            List<String> data = new ArrayList<>();
            // 3、定义循环按照行读取文章
            String line;
            while ((line = br.readLine()) != null){
                data.add(line);
            }
            System.out.println(data);
            // 4、排序
            // 自定义排序规则
            List<String> sizes = new ArrayList<>();
            Collections.addAll(sizes , "一","贰","三","四","五","陆","柒","捌","玖","十","十一");
//            Collections.sort(data);   // 只能按数字排序 1 2 3 4 5 6 7 8 9 10 11
            Collections.sort(data, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return ( sizes.indexOf(o1.substring(0, o1.indexOf(".")))
                            - sizes.indexOf(o2.substring(0, o2.indexOf("."))) );

                }
            });
            System.out.println(data);

            // 6、遍历集合中的每行文章写出去，且要换行
            for (String datum : data) {
                bw.write(datum);
                bw.newLine(); // 换行
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
```



# 二、转换流

## 1、问题引出

**1、之前我们使用字符流读取中文是否有乱码？**

* 没有的，因为代码编码和文件编码都是UTF-8。

**2、如果代码编码和文件编码不一致，使用字符流直接读取还能不乱码吗**？

* 会乱码

* 文件编码和读取的编码必须一致才不会乱码。

> **问题实验**

![](https://pic1.imgdb.cn/item/6350be4a16f2c2beb184d542.jpg)

> **注意事项**

* GBK.txt是ANSI编码
* 会乱码

> **代码：**

```java
public static void main(String[] args) {
        try (
                // 代码是UTF-8，文件也是，不会乱码
                // 1、创建一个字符输入楼管道与源文件接通
                //Reader  fr = new FileReader("day10-oop-demo/src/CopyData05.txt");
                Reader  fr = new FileReader("day10-oop-demo/src/GBK.txt");

                // a. 把地接的字符输入流包装成高级的缓冲字符输入流
                BufferedReader br = new BufferedReader(fr);
        ) {
            // 2、用循环，独有方法每次读取一行
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```

> **总结**

**1、字符流直接读取文本内容。**

* 必须文件和代码编码一致才不会乱码
* 如果文件和代码编码不一致，读取将出现乱码。



## 2、字符输入转换流

**1、如果代码编码和文件编码不一致，使用字符流直接读取还能不乱码吗？**

* 会乱码。

**2、如果如何解决呢？**

* 使用字符输入转换流
* 可以提取文件(GBK)的原始字节流，原始字节不会存在问题。
* 然后把字节流以指定编码转换成字符输入流，这样字符输入流中的字符就不乱码了

> 继承关系

![](https://pic1.imgdb.cn/item/6350c18316f2c2beb1887992.jpg)

### 2.1 字符输入转换流InputStreamReader

* public InputStreamReader(InputStream is)	可以把原始的字节流按照代码默认编码转换成字符输入流。几乎不用，与默认的FileReader-一样。
* public InputStreamReader(InputStream is,String charset)	可以把原始的字节流按照指定编码转换成字符输入流，这样字符流中的字符就不乱码了（重点）
