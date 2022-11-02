package com.study.d2_xpath;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.net.DatagramPacket;
import java.util.List;

public class XpathDemo {
    /**
     *  1、绝对路径：/根元素/子元素/孙元素
     */
    @Test
    public void parse01() throws Exception{
        // a.创建解析器对象
        SAXReader saxReader = new SAXReader();
        // b.把XML加载成Document文档对象
        Document document = saxReader.read(new File("xmldata/Contacts2.xml"));
        // c.检索全部的名称
        List<Node> nameNodes =document.selectNodes("/contactList/contact/name");
        for (Node nameNode : nameNodes) {
            Element nameEle = (Element) nameNode;
            System.out.println(nameEle.getTextTrim());
        }
    }

    /**
     * 2、相对路径：./子元素/子元素。（.代表当前元素）
     */
    @Test
    public void parse02() throws Exception{
        // a.创建解析器对象
        SAXReader saxReader = new SAXReader();
        // b.把XML加载成Document文档对象
        Document document = saxReader.read(new File("xmldata/Contacts2.xml"));
        Element root = document.getRootElement();
        // c.检索全部的名称
        List<Node> nameNodes =root.selectNodes("./contact/name");
        for (Node nameNode : nameNodes) {
            Element nameEle = (Element) nameNode;
            System.out.println(nameEle.getTextTrim());
        }
    }

    /**
     * 3、全文检索
     * //元素         在全文找这个元素
     * //元素1/元素2      在全文找元素1下面的一级元素2
     * //元素1//元素2       在全文找元素1下面的全部元素2。
     */
    @Test
    public void parse03() throws Exception{
        // a.创建解析器对象
        SAXReader saxReader = new SAXReader();
        // b.把XML加载成Document文档对象
        Document document = saxReader.read(new File("xmldata/Contacts2.xml"));
        // c.检索数据
//        List<Node> nameNodes = document.selectNodes("//name");
//        List<Node> nameNodes = document.selectNodes("//contact/name");
        List<Node> nameNodes = document.selectNodes("//contact//name");
        for (Node nameNode : nameNodes) {
            Element nameEle = (Element) nameNode;
            System.out.println(nameEle.getTextTrim());
        }
    }

    /**
     * 4、属性查找
     * // @属性名称在全文检索属性对象。
     * //元素[@属性名称]   在全文检索包含该属性的元素对象。
     * //元素[@属性名称=值]   在全文检索包含该属性的元素且属性值为该值的元素对象。
     */
    @Test
    public void parse04() throws Exception{
        // a.创建解析器对象
        SAXReader saxReader = new SAXReader();
        // b.把XML加载成Document文档对象
        Document document = saxReader.read(new File("xmldata/Contacts2.xml"));
        // c.检索数据
        List<Node> nodes = document.selectNodes("//@id");
        for (Node node : nodes) {
            Attribute attr = (Attribute) node;
            System.out.println(attr.getName() + "===>" + attr.getValue());
        }
        System.out.println("--------------------------------------------");
        List<Node> nodes1 = document.selectNodes("//name[@id]");
        for (Node node : nodes1) {
            Element nodeEle = (Element) node;
            System.out.println(nodeEle.getTextTrim());
        }
        System.out.println("--------------------------------------------");
        Node node = document.selectSingleNode("//name[@id=888]");
        Element ele = (Element) node;
        System.out.println(ele.getTextTrim());
    }
}
