# 一、XML

## 1、XML概述

* XML是可扩展标记语言(eXtensible Markup Language)的缩写，它是是一种数据表示格式，可以描述非常复杂的数据结构，常用于传输和存储数据。

![](https://pic1.imgdb.cn/item/6360f36816f2c2beb1e4b564.jpg)

> XML的几个特点：

* 一是纯文本，默认使用UTF-8编码；二是可嵌套；
* 如果把XML内容存为文件，那么它就是一个XML文件。

* XML的使用场景：**XML内容经常被当成消息进行网络传输，或者作为配置文件用于存储系统的信息。**

> XML使用场景：

![](https://pic1.imgdb.cn/item/6360f47016f2c2beb1e788b3.jpg)

> **总结：**

* 1、XML是什么？
  * XML的全称为（EXtensible Markup Language),是一种可扩展的标记语言。
  * 它是是一种数据表示格式，可以用于自定义数据格式。

* 2、XML的作用是什么？
  * 用于进行存储数据和传输数据
  * 作为软件的配置文件



## 2、XML的创建、语法规则

### 2.1 XML的创建

* 就是创建一个XML类型的文件，要求文件的后缀必须使用xml,如hello world.xml

> IDEA创建XML文件的操作步骤：

![](https://pic1.imgdb.cn/item/6360f54c16f2c2beb1e9f9c9.jpg)

### 2.2 XML的语法规则

* XML文件的后缀名为：XML
* 文档声明必须是第一行

![](https://pic1.imgdb.cn/item/6360f5ee16f2c2beb1ec30cf.jpg)

> XML的标签（元素）规则

* 标签由一对尖括号和合法标识符组成：**<name></name>**,必须存在一个根标签，**有且只能有一个**。
* 标签必须成对出现，有开始，有结束：**<name></name>**
* 特殊的标签可以不成对，但是必须有结束标记，如：**<br/>**
* 标签中可以定义属性，属性和标签名空格隔开，属性值必须用引号引起来**<student id="1"></name>**
* 标签必须正确嵌套

> XML的其他组成

- XML文件中可以定义注释信息：**<!- 注释内容 -->**
- XML文件中可以存在以下特殊字符

![](https://pic1.imgdb.cn/item/6360f74a16f2c2beb1f00a58.jpg)

* XML文件中可以存在CDATA区：**<![CDATA[ ...内容... ]]>**

### 2.3 总结

> XML的组成格式要求是什么样子的？

* 文件后缀必须是xml
* 文档声明必须是第一行
* 必须存在一个根标签，有且只能有一个
* XML文件中可以定义注释信息：<！-注释内容->
* 标签必须成对出现，有开始，有结束标签：<name></name>
* 必须能够正确的嵌套



## 3、XML文档的约束方式

### 3.1 什么是文档约束

* 问题：由于XML文件可以自定义标签，导致XML文件可以随意定义，程序在解析的时候可能出现问题。

> 什么是文档约束？

* 文档约束：是用来限定xml文件中的标签以及属性该怎么写

​								↓

​		以此强制约束程序员必须按照文档约束的规定来编写xml文件

> 文档约束的分类：

* DTD
* schema

### 3.2 XML文档约束-DTD的使用（了解）

> 需求：

* 利用DTD文档约束，约束一个XML文件的编写。

> 分析：

* ①：编写DTD约束文档，后缀必须是.dtd

  ![](https://pic1.imgdb.cn/item/6360fab216f2c2beb1fb6e42.jpg)

* ②：在需要编写的XML文件中导入该DTD约束文档

* ③：**按照约束的规定编写XML文件的内容**

> **XML的文档约束-DTD的作用和问题？**

* 可以约束XML文件的编写。
* **不能约束具体的数据类型**

### 3.3 XML文档约束方式二-schema约束（了解）

> 文档约束-schema：

* schema可以约束具体的数据类型，约束能力上更强大。
* schema.本身也是一个xml文件，本身也受到其他约束文件的要求，所以编写的更加严谨

![](https://pic1.imgdb.cn/item/6360fcd016f2c2beb101db59.jpg)

> 步骤：

* 需求：利用schema文档约束，约束一个XML文件的编写。
* 分析：
  * ①：编写schema约束文档，后缀必须是.sd,具体的形式到代码中观看。
  * ②：在需要编写的XML文件中导入该schema约束文档
  * ③：按照约束内容编写XML文件的标签。

> XML的文档约束-schema的优点？

* 可以约束XML文件的标签内容格式，以及具体的数据类型。 



## 4、XML解析技术

### 4.1 XML解析技术概述

> XML的数据的作用是什么，最终需要怎么处理？

* 存储数据、做配置信息、进行数据传输。
* 最终需要被程序进行读取，解析里面的信息。

> 什么是XML解析

* 使用程序读取XML中的数据

> 两种解析方式：

* SAX解析
* DOM解析

### 4.2 DOM常见解析工具

|   名称    |                             说明                             |
| :-------: | :----------------------------------------------------------: |
|   JAXP    |               SUN公司提供的一套XML的解析的API                |
|   JDOM    | JDOM是一个开源项目，它基于树型结构，利用纯AVA的技术对XML文档实现解析、生成、序列化以及多种操作。 |
| **dom4j** | 是DOM的升级品，用来读写XML文件的。具有性能优异、功能强大和极其易使用的特点，它的性能超过sun公司官方的dom技术，同时它也是一个开放源代码的软件，Hibernate也用它来读写配置文件。 |
|   jsoup   |    功能强大DOM方式的XML解析开发包，尤其对HTML解析更加方便    |

>  DOM解析文档对象模型

![](https://pic1.imgdb.cn/item/6361034b16f2c2beb117f8c4.jpg)

* Documenti对象：整个xml文档
* Node对象
  * Elementi对象：标签
  * Attribute对象：属性
  * Text对象：文本内容

> 总结：

* 1、Dom解析的文档对象模型是怎么样的
  * Documenti对象：整个xml文档
  * Node对象
    * Elementi对象：标签
    * Attribute对象：属性
    * Text对象：文本内容

* 2、Dom解析常用技术框架
  * Dom4j

### 4.3 使用Dom4j解析出XML文件

> 需求：

* 使用Dom4j把一个XML文件的数据进行解析

> 分析：

* ①：下载Dom4j框架，官网下载。
* ②：在项目中创建一个文件夹：lib
* ③：将dom4j-2.1.1.jar文件复制到lib文件夹
* ④：在jar文件上点右键，选择Add as Library->点击OK
* ⑤：在类中导包使用

> DOM4j解析XML-得到Decument对象

* SAXReader类

| 构造器/方法               | 说明                        |
| ------------------------- | --------------------------- |
| public SAXReader()        | 创建Dom4)的解析器对象       |
| Document read(String url) | 加载XML文件成为Document对象 |

* Document类

| 方法名                  | 说明           |
| ----------------------- | -------------- |
| Element getRootElemen() | 获得根元素对象 |

> Dom4j解析XML的元素、属性、文本

![](https://pic1.imgdb.cn/item/63610bcc16f2c2beb135a59a.jpg)

> 代码实现：

```java
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 *  目标：学会使用dom4j解析XML文件中的数据
 *  1、导入dom4j框架
 *  2、准备一个XML文件
 */
public class DOM4JHelloWorldDemo1 {
    @Test
    public void parseXMLData() throws Exception {
        // 1、创建一个Dom4j的解析器对象，代表了整个dom4j框架
        SAXReader saxReader = new SAXReader();
        // 2、把XML文件加载到内存中成为一个Document文档对象
        Document document = saxReader.read(new File("xmldata/Contacts.xml")); //需要通过模块名去定位
//        InputStream is = DOM4JHelloWorldDemo1.class.getResourceAsStream("/Contacts.xml");
//        Document document = saxReader.read(is);

        // 3、获取根元素对象
        Element root = document.getRootElement();
        System.out.println(root.getName());

        // 4、拿根蒜素下的全部子元素对象
//        List<Element> sonEles = root.elements();
        List<Element> sonEles = root.elements("contact");
        for (Element sonEle : sonEles) {
            System.out.println(sonEle.getName());
        }
        System.out.println("------------------------");

        // 拿某个子元素
        Element userEle = root.element("user");
        System.out.println(userEle.getName());
        // 默认提取第一个子元素对象
        Element contact = root.element("contact");
        // 获取子元素文本
        System.out.println(contact.elementText("name"));
        // 去掉前后空格
        System.out.println(contact.elementTextTrim("name"));

        // 根据元素获取属性值
        Attribute idAttr = contact.attribute("id");
        System.out.println(idAttr.getName() + "--->" + idAttr.getValue());
        // 直接提取属性值
        System.out.println(contact.attribute("id"));
        System.out.println(contact.attribute("vip"));


        // 获取当前元素下的子元素对象
        Element email = contact.element("email");
        System.out.println(email.getText());

    }
}
```

> Dom4j的解析思想？

* 得到文档对象Document,从中获取元素对象和内容。