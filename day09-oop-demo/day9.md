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

