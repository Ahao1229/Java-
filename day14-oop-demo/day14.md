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



### 4.4 XML解析案例

> 需求：

* 利用Dom4的知识，将Contact.xml文件中的联系人数据封装成List集合，其中每个元素是实体类Contact。,打印输出List中的每个元素。

> 代码实现：

* Contact对象类：

```java
public class Contact {
    private String name;
    private int id;
    private boolean vip;
    private char gender;
    private String email;

    public Contact() {
    }

    public Contact(String name, int id, boolean vip, char gender, String email) {
        this.name = name;
        this.id = id;
        this.vip = vip;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", vip=" + vip +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
```

* DOM4JTest2：

```java
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DOM4JTest2 {
        // 需求：解析XML文件中的数据成为一个List集合对象
    @Test
    public void parseToList() throws Exception {
        // 1、导入框架
        // 2、创建SaxReader对象
        SAXReader saxReader = new SAXReader();
        // 3、加载XML文件成为文档对象Document对象。
        Document document = saxReader.read(new File("xmldata/Contacts.xml"));
        // 4、先拿根元素
        Element root = document.getRootElement();
        // 5、提取contact子元素
        List<Element> contactEles = root.elements("contact");
        // 6、准备一个ArrayList集合封装联系人信息
        List<Contact> contacts = new ArrayList<>();
        // 7、遍历Contact子元素
        for (Element contactEle : contactEles) {
            // 8、每个子元素都是一个联系人对象
            Contact contact = new Contact();
            contact.setId(Integer.valueOf(contactEle.attributeValue("id")));
            contact.setVip(Boolean.valueOf(contactEle.attributeValue("vip")));
            contact.setName(contactEle.elementTextTrim("name"));
            contact.setGender(contactEle.elementTextTrim("gender").charAt(0));
            contact.setEmail(contactEle.elementText("email"));
            // 9、把联系人对象数据假如到List集合
            contacts.add(contact);
        }
        // 10、遍历List集合
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }


}
```



## 5、XML检索技术：Xpath

### 5.1 问题引入

> 如果需要从XML文件中检索需要的某个信息（如name)怎么解决？

* Dom4j需要进行文件的全部解析，然后再寻找数据。
* Xpath技术更加适合做信息检索。

### 5.2 Xpath介绍

* XPth在解析XML文档方面提供了一独树一帜的路径思想，更加优雅，高效
* XPath使用路径表达式来定位XML文档中的元素节点或属性节点。

> 示例

* /元素/子元素/孙元素
* //子元素//孙元素

### 5.3 使用Xpath检索出XML文件

> 需求：

* 使用Dom4J把一个XML文件的数据进行解析

> 分析：

* ①导入jar包(dom4j和axen-1.1.2.jar),Xpath技术依赖Dom4j技术

* ② 通过dom4j的SAXReader获取Document对象

* ③ 利用XPth提供的API,结合XPath的语法完成选取XML文档元素节点进行解析操作。

* ④ Document中与Xpath相关的API如下：

  |               方法名               |           说明           |
  | :--------------------------------: | :----------------------: |
  | Node   selectSingleNode("表达式")  | 获取符合表达式的唯一元素 |
  | List<Node>   selectNodes("表达式") | 获取符合表达式的元素集合 |

### 5.4 Xpath的四大检索方案

* 绝对路径
  * 采用绝对路径获取从根节点开始逐层的查找/contactList/contact/name节点列表并打印信息
  * 从根元素开始，一级一级向下查找，不能跨级，/根元素/子元素/孙元素
* 相对路径
  * 先得到根节点contactList
  * 再采用相对路径获取下一级contact节点的name子节点并打印信息
  * 从当前元素开始，一级一级向下查找，不能跨级， ./子元素/孙元素
* 全文检索
  * 直接全文搜索所有的name元素并打印
  * //contact，找contact元素，无论元素在哪里
  * //contact/name，找contact,无论在哪一级，但name一定是contact的子节点
  * //contact//name，contact无论在哪一种，name只要是contact的子孙元素都可以找到
* 属性查找
  * 在全文中搜索属性，或者带属性的元素
  * //@属性名，查找属性对象，无论是哪个元素，只要有这个属性即可。
  * //元素[@属性名]，查找元素对象，全文搜索指定元素名和属性名。
  * //元素//[@属性名=‘值']，查找元素对象，全文搜索指定元素名和属性名，并且属性值相等。

### 5.5 总结

![](https://pic1.imgdb.cn/item/6361e6e816f2c2beb17d0820.jpg)



## 6、设计模式

### 6.1 工厂模式

> 什么是工厂模式

* 之前我们创建类对象时，都是使用new对象的形式创建，在很多业务场景下也提供了不直接new的方式。

* 工厂模式(Factory Pattern)是Java中最常用的设计模式之一，这种类型的设计模式属于创建型模式，它提供了一种获取对象的方式。

> 工厂设计模式的作用：

* 工厂的方法可以封装对象的创建细节，比如：为该对象进行加工和数据注入。
* 可以实现类与类之间的解耦操作（核心思想）

### 6.2 装饰模式

> 什么是装饰模式

* 创建一个新类，包装原始类，从而在新类中提升原来类的功能。

> 装饰设计模式的作用

* 作用：装饰模式指的是在不改变原类的基础上，动态地扩展一个类的功能。

![](https://pic1.imgdb.cn/item/63624d2d16f2c2beb1d56e59.jpg)

* ① 定义父类。
* ② 定义原始类，继承父类，定义功能。
* ③ 定义装饰类，继承父类，
* ④ 包装原始类，增强功能！！
