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
* **==public InputStreamReader(InputStream is,String charset)==	可以把原始的字节流按照指定编码转换成字符输入流，这样字符流中的字符就不乱码了==（重点）==**

> **代码演示：**

```java
 public static void main(String[] args) throws Exception {
        // 1、提取GBK文件的原始字节流
        InputStream is = new FileInputStream("day10-oop-demo/src/GBK.txt");
        // 2、把原始字节流转换成字符输入流
//        Reader isr = new InputStreamReader(is); // 默认UTF-8的方式转换成字符流，还是会乱码;
        Reader isr = new InputStreamReader(is , "GBK"); // 以指定的GBK编码转换成字符输入流  完美解决乱码问题
        // 3、包装成缓冲流然后按行读取
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }
```

> **字符输入转换流InputStreamReader作用：**

* 可以解决字符流读取不同编码乱码的问题
* **==public InputStreamReader(InputStream is , String charset)==	:	可以指定编码把原始字节流转换成字符流，如此字符流中的字符不乱码。**



### 2.2 字符输出转化流OutputstreamWriter

> **问题引出：**

如果需要控制写出去的字符使用的编码，怎么办

* 可以把字符以指定编码获取字节后再使用字节输出流写出去：
  * "我爱你中国".getBytes(编码)
  * **也可以使用字符输出转换流实现。**

> **字符输出流的作用：**

* public OutputstreamWriter( Outputstream os , String charset )
* 可以指定编码把字节输出流转换成字符输出流，从而可以指定写出去的字符编码！

> **代码演示：**

```java
public static void main(String[] args) throws Exception {
        // 1、定义一个字节输出流;
        OutputStream os = new FileOutputStream("day10-oop-demo/src/out07.txt");

        // 2、把原始的字节输出流转换成字符输出流
//        Writer isw = new OutputStreamWriter(os);    // 以默认的UTF-8写字符出去 跟直接写FileWriter一样
        Writer isw = new OutputStreamWriter(os, "GBK");    // 指定GBK编码写字符出去

        // 3、把低级的字符输出流包装成高级的缓冲字符输出流
        BufferedWriter bw = new BufferedWriter(isw);
        bw.write("我爱你中国！~~");
        bw.write("我爱你河北！~~");
        bw.write("我爱你邢台！~~");

        bw.close();
    }
```

# 三、序列化对象

## 1、对象序列化

* **==作用：以内存为基准，把内存中的对象存储到磁盘文件中去，称为对象序列化。==**

> **图解**

![](https://pic1.imgdb.cn/item/6350f1f516f2c2beb100ab7c.jpg)

> **使用到的流是对象字节输出流：ObjectOutputStream**

* public Objectoutputstream( OutputStream out ) 把低级字节输出流包装成高级的对象字节输出流

> 代码实现

* 先写一个学生类（必须实现Serializable接口，就是表面）
* 一些敏感信息，比如密码可以用transient进行修饰，修饰之后就不会参与序列化，反序列化之后显示默认值（比如字符串显示null，整型显示0）
* 序列化版本号定义之后，如果修改了版本号，不重新序列化直接反序列化的话会报错

```java
public class Student implements Serializable {
    private String name;
    private String loginName;
    // 序列化的版本号与反序列化的版本号必须一致才不会出错
    private static final long serialVersionUID = 1;
    //transient 修饰的变量不会被序列化。
    private transient String passWord;
    private int age;

    public Student() {
    }

    public Student(String name, String loginName, String passWord, int age) {
        this.name = name;
        this.loginName = loginName;
        this.passWord = passWord;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                '}';
    }
}
```

* 对象序列化代码：

```java
 public static void main(String[] args) throws Exception {
        // 1、创建学生对象
        Student s = new Student("飞飞","feifei","1314520",21);

        // 2、对象序列化:使用对象字节输出流包装字节输出流管道
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("day10-oop-demo/src/obj.txt"));

        // 3、直接调用序列化方法
        oos.writeObject(s);

        // 4、释放资源
        oos.close();
        System.out.println("序列化完成");
    }
```

> **总结**

**1.对象序列化的含义是什么？**

* 把对象数据存入到文件中去。

**2、对象序列化用到了哪个流？**

* 对象字节输出流objectOutputstram
* public void writeobject(object obj)

**3、序列化对象的要求是怎么样的？**

* 对象必须实现序列化接口



## 2、对象反序列化

* **==作用：以内存为基准，把存储到磁盘文件中去的对象数据恢复成内存中的对像，称为对像反序列化。==**

> **图解**

![](https://pic1.imgdb.cn/item/6350fbb616f2c2beb113996b.jpg)

> **使用到的流是对象字节输入流：ObjectInputStream**

* public ObjectInputStream( InputStream out )把低级字节输如流包装成高级的对象字节输入流

* public Object readObject() 把存储到磁盘文件中去的对象数据恢复成内存中的对象返回

> **反序列化代码：**

```java
 public static void main(String[] args) throws Exception {
        // 1、创建字节对象输入流管道包装成低级的字节输入流管道
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("day10-oop-demo/src/obj.txt"));

        // 2、调用对象字节输入流的反序列化方法
        Student s = (Student) is.readObject();
        System.out.println(s);
    }
```

> **总结**

1.对象反序列化的含义是什么？

* 把磁盘中的对象数据恢复到内存的ava对象中。

2.对象反序列化用到了哪个流？

* 对象字节输入流 ObjectInputStram
* public object readObject()



# 四、打印流

## 1、PrintStream 和 PrintWriter

> 类的继承关系图

![](https://pic1.imgdb.cn/item/6351002e16f2c2beb11baa2c.jpg)

> 打印流

* **作用：打印流可以实现方便、高效的打印数据到文件中去。**打印流一般是指：PrintStream , PrintWriteri两个类。
* **可以实现打印什么数据就是什么数据，**例如打印整数97写出去就是97，打印boolean的true,写出去就是true。
* **都是覆盖管道，要做追加管道的话只能包装低级管道**
  * 例如：PrintStream ps= new PrintStream(new FileOutputStream("day10-oop-demo/src/ps.txt", true));

### 1.1 PrintStream

* public Printstream(OutputStream os)   打印流直接通向字节输出流管道
* public PrintStream(File f)   打印流直接通向文件对象
* public Printstream(String filepath)   打印流直接通向文件路径

* public void print(Xxx xx)   打印任意类型的数据出去

> **打印功能代码（与PrintWriter没有区别）：**

```java
public static void main(String[] args) throws Exception {
        // 1、创建一个打印流对象
//        PrintStream ps= new PrintStream(new FileOutputStream("day10-oop-demo/src/ps.txt", true));
        PrintStream ps = new PrintStream("day10-oop-demo/src/ps.txt");

        ps.println(97);
        ps.println('a');
        ps.println(23.3);
        ps.println(true);
        ps.println("我是打印流输出的，我是啥就打印啥");
	//  PrintStream 写的是字节
    	ps.write(123);
        ps.close();
    }
```



### 1.2 PrintWriter

* public PrintWriter(OutputStream os)   打印流直接通向字节输出流管道
* public PrintWriter (Writer w)   打印流直接通向字符输出流管道
* public PrintWriter(File f)   打印流直接通向文件对象
* public PrintWriter(String filepath)   打印流直接通向文件路径

* public void print(Xxx xx)   打印任意类型的数据出去

> **打印功能代码（与PrintStream没有区别）：**

```java
 public static void main(String[] args) throws Exception {
        // 1、创建一个打印流对象
//        PrintStream ps= new PrintStream(new FileOutputStream("day10-oop-demo/src/ps.txt"));
        PrintWriter ps = new PrintWriter("day10-oop-demo/src/ps.txt");

        ps.println(97);
        ps.println('a');
        ps.println(23.3);
        ps.println(true);
        ps.println("我是打印流输出的，我是啥就打印啥");
     // PrintWriter 写的是字符
		ps.write("我在学习！");
        ps.close();
    }
```



### 1.3 PrintStream 和 PrintWriter 的区别

* **打印数据功能上是一模一样的，都是使用方便，性能高效（核心优势）**
* **PrintStream继承自字节输出流OutputStream,支持写字节数据的方法。**
* **PrintWriter继承自字符输出流Writer,支持写字符数据出去。**



### 1.4 总结

> **1、打印流有几种？各有什么特点？**

* 打印流一般是指：Printstream,PrintWriteri两个类。
* 打印功能2者是一样的使用方式
* PrintStream继承自字节输出流OutputStream,支持写字节
* PrintWrite继承自字符输出流Writer,支持写字符

> **2、打印流的优势是什么？**

* 两者在打印功能上都是使用方便，性能高效（核心优势）



## 2、输出语句的重定向

* 属于打印流的一种应用，可以把输出语句的打印位置改到文件
  * PrintStream ps=new PrintStream("文件地址")
  * System.setOut(ps);

> **代码：**

```java
 public static void main(String[] args) throws Exception {
        // 打印到控制台
        System.out.println("锦瑟无端五十弦");
        System.out.println("一弦一柱思华年");

        // 改变输出语句的位置（重定向）
        PrintStream ps = new PrintStream("day10-oop-demo/src/log.txt");
        System.setOut(ps); // 把系统打印流改成我们自己的打印流

        System.out.println("庄生晓梦迷蝴蝶");
        System.out.println("望帝春心托杜鹃");
    }
```



# 五、Properties

> **继承关系图：**

![](https://pic1.imgdb.cn/item/6351092216f2c2beb12b4a88.jpg)

> **Properties属性集对象**

* 其实就是一个Map集合，但是我们一般不会当集合使用，因为HashMap更好用。

> **Properties核心作用：**

* Properties代表的是一个属性文件，可以把自己对象中的键值对信息存入到一个属性文件中去。
* 属性文件：后缀是.properties:结尾的文件，里面的内容都是key=value,后续做系统配置信息的。

> **Properties的API：**

* **Properties 和 IO流结合的方法：**
  * void load( InputStream instream )   从输入字节流读取属性列表（键和元素对）
  * ==void load( Reader reader )==   从输入字符流读取属性列表（键和元素对）
  * void store( OutputStream out,String comments )   将此属性列表（键和元素对）写入此Properties表中，以适合于使用Ioad(InputStream)方法的格式写入输出字节流
  * ==void store ( Writer writer,String comments )==   将此属性列表（键和元素对）写入此Properties表中，以适合使用load(Reader)方法的格式写入输出字符流
  * public Object setProperty( String key,String value )   保存键值对(put)
  * public String getProperty( String key )   使用此属性列表中指定的键搜索属性值(get)
  * public Set<string>stringPropertyNames()   所有键的名称的集合(keySet())

> **Properties 把键值对信息存到属性文件中：**

```java
public static void main(String[] args) throws Exception {
        // 需求：使用Properties把键值对信息存入到属性文件中去
        Properties properties = new Properties();
        properties.setProperty("admin", "123456");
        properties.setProperty("Ahao", "011229");
        properties.setProperty("feifei", "haowife");
        System.out.println(properties);

        /**
         *  参数一：保存管道，字符输出流管道
         *  参数二：保存心得
         */
        properties.store(new FileWriter("day10-oop-demo/src/user.properties"), "注释");

    }
```

> **Properties 加载属性文件**

```java
 public static void main(String[] args) throws Exception{
        // 需求：Properties读取属性文件中的键值对信息。（读取）
        Properties properties = new Properties();
        System.out.println(properties);

        // 加载属性文件中的减值对数据到属性对象properties中去
        properties.load(new FileReader("day10-oop-demo/src/user.properties"));

        System.out.println(properties);

        String rs = properties.getProperty("Ahao");
        String rs1 = properties.getProperty("admin");
        System.out.println(rs);
        System.out.println(rs1);
    }
```

> **总结：**

1、Properties的作用？

* 可以存储Properties.属性集的键值对数据到属性文件中去：
  * void store(Writer writer,String comments)
* 可以加载属性文件中的数据到Properties对象中来：
  * void load(Reader reader)



# 六、IO框架

## 1、commins-io 概述

* commons-io是apache开源基金组织提供的一组有关IO操作的类库，可以提高lO功能开发的效率。
* commons-io工具包提供了很多有关io操作的类。有两个主要的类FileUtils,IOUtils

### 1.1 FileUtils

* FileUtils主要有如下方法

  * String readFileToString(File file,String encoding)   读取文件中的数据，返回字符串
  * void copyFile(File srcFile,File destFile)   复制文件。
  * void copyDirectoryToDirectory(File srcDir,File destDir)   复制文件夹。

  

### 1.2 **导入commons-io-2.6jar做开发**

![](https://pic1.imgdb.cn/item/6351181216f2c2beb13e0715.jpg)



### 1.3 案例

> * 代码

```java
package com.study.d8_commons_io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CommonsIODemo1 {
    public static void main(String[] args) throws Exception{
        // 1、完成文件的复制
        IOUtils.copy(new FileInputStream("day10-oop-demo/src/CopyData05.txt"),
                new FileOutputStream("day10-oop-demo/src/CopyData06.txt"));
        // 2、完成文件复制到文件夹下
        FileUtils.copyFileToDirectory(new File("day10-oop-demo/src/CopyData05.txt"),
                new File("day10-oop-demo/new/"));
        // 3、完成文件夹复制到某个文件夹下
        FileUtils.copyDirectoryToDirectory(new File("day10-oop-demo/new") , new File("day10-oop-demo/new1"));
        // 4、删除文件夹
        FileUtils.deleteDirectory(new File("day10-oop-demo/new1"));
    }
}
```

