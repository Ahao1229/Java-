# 一、网络编程

## 1、什么是网络编程

* 网络编程可以让程序与网络上的其他设备中的程序进行数据交互。

> **网络通信基本模式**

* 常见的通信模式有如下2种形式：Client-Server(CS)、Browser/Server(BS)

## 2、CS模式（服务器客户端模式）

![](https://pic1.imgdb.cn/item/63573b0816f2c2beb10af31b.jpg)

## 3、BS模式（浏览器客户端模式）

![](https://pic1.imgdb.cn/item/63573b8216f2c2beb10b3efa.jpg)

## 4、网络编程需要学会什么

* **网络通信三要素：**一个消息发送给对方需要哪些关键因素。
* UDP通信：消息直接发送给对象，不确认对方是否在线，不做消息确认。
* **TCP通信：**基于可靠传输的方式进行的通信模式。解决不同场景的通信需求。
* 即时通信：如何实现即时通信，具体是是如何实现的。

* **模拟BS系统**：WEB系统是如何支持访问到网页的，具体是如何与服务器通信的。



# 二、网络通信三要素

* **IP地址:**设备在网络中的地址，是唯一的标识。
* **端口**：应用程序在设备中唯一的标识。
* **协议**：数据在网络中传输的规则，常见的协议有UDP协议和TCP协议。

## 1、要素一：IP地址

* IP(Internet Protocol)：全称”互联网协议地址”，是分配给上网设备的唯一标志。
* 常见的IP分类为IPv4 和 IPv6

### 1.1 IPv4和IPv6

> **IPv4：**

![](https://pic1.imgdb.cn/item/63573fdb16f2c2beb10edf5f.jpg)

> **IPv6：**

* IPv6：128位（16个字节)，号称可以为地球每一粒沙子编号。

* IPv6分成8个整数，每个整数用四个十六进制位表示，数之间用冒号(：)分开。

![](https://pic1.imgdb.cn/item/6357404516f2c2beb10f3016.jpg)

### 1.2 IP地址基本寻路

![](https://pic1.imgdb.cn/item/635740ca16f2c2beb10f9e94.jpg)

### 1.3 IP地址形式：

* **公网地址 和 私有地址 （局域网使用）**

* 192.168.开头的就是常见的局域网地址，范围即为192.168.0.0-192.168.255.255，专门为组织机构内部使用。

> **IP常用命令：**

* **ipconfig：查看本机IP地址**
* **ping IP地址：查看网络是否连通**

> **特殊IP地址：**

* **本机IP:127.0.0.1或者localhost:称为回送地址也可称本地回环地址，只会寻找当前所在本机。**

### 1.4 总结

> **1、说说网络通信至少需要几个要素**

* **IP、端口、协议**

> **2、IP地址是做什么的，具体有几种**

* **定位网络上的设备的，有IPv4,IPv6.**

> **3、如何查看本机P地址，如何看是否与对方互通**

* **ipcofig**
* **ping192.168.10.23**

> **4、本机IP是谁？**

* **127.0.0.1 或者 localhost**



## 2、IP地址操作类 - InteAddress 

### 2.1 InteAddress使用

* 此类表示Internet协议（IP）地址

### 2.2 InteAddress的API

|                       名称                       |                      说明                       |
| :----------------------------------------------: | :---------------------------------------------: |
|     public static InetAddress getLocalHost()     |              返回本主机的地址对象               |
| public static InetAddress getByName(String host) |  得到指定主机的P地址对象，参数是域名或者P地址   |
|           public String getHostName()            |               获取此P地址的主机名               |
|          public String getHostAddress()          |                 返回P地址字符串                 |
|     public boolean isReachable(int timeout)      | 在指定毫秒内连通该P地址对应的主机，连通返回true |

### 2.3 idea代码实现

```java
import java.net.InetAddress;
public class InterAddressDemo1 {
    public static void main(String[] args) throws Exception{
        // 1、获取本机地址对象。
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println(ip1);
        System.out.println(ip1.getHostName());
        System.out.println(ip1.getHostAddress());

        System.out.println("==========================================");

        // 2、获取域名ip对象
        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2);
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());

        System.out.println("==========================================");

        // 3、获取公网IP对象
        InetAddress ip3 = InetAddress.getByName("39.156.66.18");
        System.out.println(ip3.getHostName());
        System.out.println(ip3.getHostAddress());

        System.out.println("==========================================");

        // 4、判断是否能通：    ping    5s之前测试是否可通
        System.out.println(ip3.isReachable(5000));
    }
}
```

### 2.4 总结

> **1、IP地址的代表类是谁？**

* **InetAddress类**

> **2、如何获取本机IP对象**

* **public static InetAddress getLocalHost()**

> **3、如何判断与该P地址对象是否互通？**

* **public boolean isReachable(int timeout)**



## 3、要素二：端口号

### 3.1 端口号

* **端口号：**标识正在计算机设备上运行的进程（程序），被规定为一个16位的二进制，范围是0~65535。
* **端口类型：**
  * **周知端口：**0~1023，被预先定义的知名应用占用（如：HTTP占用80，FTP占用21)
  * **==注册端口：==**1024~49151，分配给用户进程或某些应用程序。（如：Tomcat占用8080，MySQL占用3306）
  * **动态端口：**49152到65535，之所以称为动态端口，是因为它一般不固定分配某种进程，而是动态分配。

**==注意：我们自己开发的程序选择注册端口，且一个设备中不能出现两个程序的端口号一样，否则出错。==**

### 3.2 总结

>  **1、端口号的作用是什么？**

* **唯一标识正在计算机设备上运行的进程（程序）**

> **2、一个设备中，能否出现2个应用程序的端口号一样，为什么？**

* **不可以，如果一样会出现端口冲突错误。**



## 4、要素三：协议

### 4.1 通信协议

* 连接和通信数据的规则被称为网络通信协议

### 4.2 网络通信协议有两套参考模型

* OSI参考模型：世界互联协议标准，全球通信规范，由于此模型过于理想化，未能在因特网上进行广泛推广。
* TCP/IP参考模型（或TCP/IP协议）：事实上的国际标准。

![](https://pic1.imgdb.cn/item/63574a0416f2c2beb119306b.jpg)

### 4.3 传输层的两个常见协议

* **TCP(Transmission Control Protocol) : 传输控制协议**
* **UDP(User Datagram Protocol) : 用户数据报协议**

### 4.4 TCP协议

> **TCP协议特点**

* 使用TCP协议，必须双方先建立连接，它是一种**面向连接**的**可靠通信**协议。
* 传输前，采用"**三次握手**”方式建立连接，所以是可靠的。
* 在连接中可进行大数据量的传输。
* 连接、发送数据都需要确认，且传输完毕后，还需释放已建立的连接，通信效率较低。

> **TCP协议通信场景**

* 对信息安全要求较高的场景，例如：文件下载、金融等数据通信。

> **TCP三次握手确立连接**

![](https://pic1.imgdb.cn/item/63574b4f16f2c2beb11a9e93.jpg)

> **TCP四次挥手断开连接**

![](https://pic1.imgdb.cn/item/63574bc516f2c2beb11b00cf.jpg)

### 4.5 UDP协议

> **UDP协议**

* UDP是一种**无连接**、**不可靠传输**的协议。
* 将数据源P、目的地P和端口封装成数据包，不需要建立连接
* 每个数据包的大小限制在64KB内
* 发送不管对方是否准备好，接收方收到也不确认，故是不可靠的
* 可以广播发送，发送数据结束时无需释放资源，开销小，速度快。

> UDP协议通信场景

* 语音通话，视频会话等。

### 4.6 总结

> **1、通信协议是什么？**

* **计算机网络中，连接和通信数据的规则被称为网络通信协议。**

> **2、TCP通信协议的特点是什么样的？**

* **它是一种面向连接的可靠通信协议。**
* **传输前，采用“三次握手”方式建立连接，点对点的通信，所以可靠。**
* **在连接中可进行大数据量的传输。**
* **通信效率较低。**

> **3、UDP协议的特点是什么**

* **用户数据报协议(User Datagram Protocol)**
* **UDP是面向==无连接，不可靠传输的==通信协议。**
* **速度快，有大小限制一次最多发送64K,数据不安全，易丢失数据。**



# 三、UDP通信

## 1、UDP通信：快速入门

### 1.1 UDP协议的特点

* UDP是一种无连接、不可靠传输的协议。
* 将数据源IP、目的地IP和端口以及数据封装成数据包，大小限制在64KB内，直接发送出去即可。

### 1.2 UDP协议通信模型演示

![](https://pic1.imgdb.cn/item/63574da816f2c2beb11d3865.jpg)

![](https://pic1.imgdb.cn/item/63574df416f2c2beb11d84d6.jpg)

### 1.3 实现UDP通信

> **DatagramPacket：数据包对象（韭菜盘子）**

* **DatagramPacket构造器：**

![](https://pic1.imgdb.cn/item/63574e5f16f2c2beb11de8db.jpg)

* **DatagramPacket常用方法：**
  * public int getLength（）：获得实际接收到的字节个数

> **DatagramSocket：发送端和接收端对象（人）**

* **DatagramSocket构造器**

|             构造器              |                        说明                         |
| :-----------------------------: | :-------------------------------------------------: |
|     public DatagramSocket()     | 创建发送端的Socketj对像，系统会随机分配一个端口号。 |
| public DatagramSocket(int port) |         创建接收瑞的Socket对像并指定端口号          |

* **DatagramSocket类的成员方法**

|                 方法                  |    说明    |
| :-----------------------------------: | :--------: |
|  public void send(DatagramPacket dp)  | 发送数据包 |
| public void receive(DatagramPacket p) | 接收数据包 |

### 1.4 idea实现

> **服务端（接收端）代码：**

```java
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 接收端
 */
public class ServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        // 1、创建接受端对象：注册端口（人）
        DatagramSocket socket = new DatagramSocket(8888);

        // 2、创建一个数据包对象接受数据（韭菜盘子）
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket packet =new DatagramPacket(buffer, buffer.length);

        // 3、等待接受数据
        socket.receive(packet);

        // 4、取出数据即可
        // 读多少取多少
        int len = packet.getLength();
        String rs = new String(buffer, 0 ,len);
        System.out.println("收到了" + rs);

         // 获取发送端的ip和端口
        System.out.println("发送端的地址:" + packet.getSocketAddress().toString());
        System.out.println("发送端的端口:" + packet.getPort());
        
        // 5、关掉管道
        socket.close();

    }
}
```

> **客户端（发送端）代码：**

```java
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * 发送端  一发  一收
 */
public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======客户端启动======");
        // 1、创建一个发送端对象：发送端自带默认的端口号（人）
        DatagramSocket socket = new DatagramSocket(6666);

        // 2、创建一个数据包对象封装数据（韭菜盘子）
        /**
         public DatagramPacket(byte buf[], int offset, int length,
         InetAddress address, int port)
         参数一：封装要发送的数据（韭菜）
         参数二：发送数据的大小
         参数三：服务端的IP地址
         参数四：服务端的端口
         */
        byte[] buffer = "我是一颗快乐的韭菜，你愿意割吗？".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet =new DatagramPacket(buffer, buffer.length , InetAddress.getLocalHost(), 8888);

        // 3、发送数据出去
        socket.send(packet);
        
        // 4、管道关掉
        socket.close();

    }
}
```

> 运行结果（先运行服务端再运行客户端）：

![](https://pic1.imgdb.cn/item/635755fa16f2c2beb1265e74.jpg)

### 1.5 总结

> 1、UDP发送端和接收端的对象是哪个？

* public DatagramSocket():创建发送端的Socket对象
* public DatagramSocket(int port):创建接收端的Socket对象

> 2、数据包对象是哪个？

* DatagramPacket

> 3、如何发送、接收数据包

* 使用DatagramSocket的如下方法：
* public void send(DatagramPacket dp):发送数据包
* public void receive(DatagramPacket dp):接收数据包



## 2、UDP通信：多发多收

### 2.1 案例：使用UDP通信实现：多发多收消息

> **需求：**

* 使用UDP通信方式开发接收端和发送端。

> **分析：**

① 发送端可以一直发送消息。

② 接收端可以不断的接收多个发送端的消息展示。

③ 发送端输入了exit则结束发送端程序。

### 2.2 步骤分析

> **发送端可以反复发送数据：**

**需求：客户端实现步骤**

* ① 创建DatagramSocket对像（发送端对象）扔韭菜的人
* ② 使用while死循环不断的接收用户的数据输入，如果用户输入的exit则退出程序
* ③ 如果用户输入的不是exit,把数据封装成DatagramPacket       韭菜盘子
* ④ 使用DatagramSocket对象的send方法将数据包对象进行发送    开始抛出韭菜
* ⑤ 释放资源

> **接收端可以反复接受数据：**

**需求：接收端实现步骤**

* ① 创建DatagramSocketi对象并指定端口（接收端对象）  接韭菜的人
* ②创建DatagramPacket对象接收数据（数据包对象)  韭菜盘子
* ③使用while死循环不断的进行第4步
* ④ 使用DatagramSocket对象的receive方法传入DatagramPacket对象      开始接收韭菜

### 2.3 idea代码实现

> **服务端（接收端）代码：**

```java
public class ServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        // 1、创建接受端对象：注册端口（人）
        DatagramSocket socket = new DatagramSocket(8888);

        while (true) {
            // 2、创建一个数据包对象接受数据（韭菜盘子）
            byte[] buffer = new byte[1024 * 64];
            DatagramPacket packet =new DatagramPacket(buffer, buffer.length);

            // 3、等待接受数据
            socket.receive(packet);

            // 4、取出数据即可
            // 读多少取多少
            int len = packet.getLength();
            String rs = new String(buffer, 0 ,len);
            System.out.println("收到了来自：" + packet.getAddress()+ "对方端口是：" + packet.getPort()+"的消息：" + rs);

        }
    }
}
```

> **客户端（发送端）代码：**

```java
public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======客户端启动======");
        // 1、创建一个发送端对象：发送端自带默认的端口号（人）
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请说：");
            String msg = sc.nextLine();

            if ("exit".equals(msg)){
                System.out.println("离线成功！");
                socket.close();
                break;
            }

            // 2、创建一个数据包对象封装数据（韭菜盘子）
            byte[] buffer = msg.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet =new DatagramPacket(buffer, buffer.length , InetAddress.getLocalHost(), 8888);

            // 3、发送数据出去
            socket.send(packet);
        }

    }
}
```

> **客户端多开：**

![](https://pic1.imgdb.cn/item/63575ab316f2c2beb12b3f88.jpg)

![](https://pic1.imgdb.cn/item/63575ad716f2c2beb12b9b6c.jpg)

> **运行结果：**

![](https://pic1.imgdb.cn/item/63575c2816f2c2beb12cd4cd.jpg)

### 2.4 总结

> UDP的接收端为什么可以接收很多发送端的消息？

* 接收端只负责接收数据包，无所调是哪个发送端的数据包，



## 3、UDP通信-广播、组播

### 3.1 UDP的三种通信方式

* 单播：单台主机与单台主机之间的通信。
* 广播：当前主机与所在网络中的所有主机通信。
* 组播：当前主机与选定的一组主机的通信。

### 3.2 UDP如何实现广播

* 使用广播地址：255.255.255.255
* 具体操作：
  * ① **发送端**发送的数据包的目的地写的是广播地址、且指定端口。
    **(255.255.255.255,9999)**
  * ② 本机所在网段的**其他主机**的程序只要匹配端口成功即就可以收到消息了。**(9999)**

> **代码实现：**

* 服务端

```java
public class ServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        // 1、创建接受端对象：注册端口（人）
        DatagramSocket socket = new DatagramSocket(9999);

        while (true) {
            // 2、创建一个数据包对象接受数据（韭菜盘子）
            byte[] buffer = new byte[1024 * 64];
            DatagramPacket packet =new DatagramPacket(buffer, buffer.length);

            // 3、等待接受数据
            socket.receive(packet);

            // 4、取出数据即可
            // 读多少取多少
            int len = packet.getLength();
            String rs = new String(buffer, 0 ,len);
            System.out.println("收到了来自：" + packet.getAddress()+ "对方端口是：" + packet.getPort()+"的消息：" + rs);

        }



    }
}
```

* 客户端

```java
public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======客户端启动======");
        // 1、创建一个发送端对象：发送端自带默认的端口号（人）
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请说：");
            String msg = sc.nextLine();

            if ("exit".equals(msg)){
                System.out.println("离线成功！");
                socket.close();
                break;
            }

            // 2、创建一个数据包对象封装数据（韭菜盘子）
            byte[] buffer = msg.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet =new DatagramPacket(buffer, buffer.length , InetAddress.getByName("255.255.255.255"), 9999);

            // 3、发送数据出去
            socket.send(packet);
        }

    }
}
```

### 3.3 UDP如何实现组播

* 使用组播地址：224.0.0.0~239.255.255.255
* 具体操作：
  * ① 发送端的数据包的目的地是组播1P(例如：224.0.1.1，端口：9999)
  * ② 接收端必须绑定该组播1P(224.0.1.1),端口还要对应发送端的目的端口9999，这样即可接收该组播消息。
  * ③ DatagramSocket的子类MulticastSocket可以在接收端绑定组播IP.

> **代码实现：**

* 服务端代码：

```java
public class ServerDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======服务端启动======");
        // 1、创建接受端对象：注册端口（人）
        MulticastSocket socket = new MulticastSocket(9999);
        // 把当前接收器假如到之前一个组播组中去：绑定对应的组播详细的组播IP
        socket.joinGroup(new InetSocketAddress(InetAddress.getByName("224.0.1.1"),9999),
                NetworkInterface.getByInetAddress(InetAddress.getLocalHost()));
        while (true) {
            // 2、创建一个数据包对象接受数据（韭菜盘子）
            byte[] buffer = new byte[1024 * 64];
            DatagramPacket packet =new DatagramPacket(buffer, buffer.length);

            // 3、等待接受数据
            socket.receive(packet);

            // 4、取出数据即可
            // 读多少取多少
            int len = packet.getLength();
            String rs = new String(buffer, 0 ,len);
            System.out.println("收到了来自：" + packet.getAddress()+ "对方端口是：" + packet.getPort()+"的消息：" + rs);

        }



    }
}
```

* 客户端代码

```java
public class ClientDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("======客户端启动======");
        // 1、创建一个发送端对象：发送端自带默认的端口号（人）
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请说：");
            String msg = sc.nextLine();

            if ("exit".equals(msg)){
                System.out.println("离线成功！");
                socket.close();
                break;
            }

            // 2、创建一个数据包对象封装数据（韭菜盘子）
            byte[] buffer = msg.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet =new DatagramPacket(buffer, buffer.length , InetAddress.getByName("224.0.1.1"), 9999);

            // 3、发送数据出去
            socket.send(packet);
        }

    }
}
```

### 3.4 总结

> 1、如何实现广播，具体怎么操作？

* 发送端目的IP使用广播IP:255.255.255.255         9999。
* 所在网段的其他主机对应了端口(9999)即可接收消息。

> 2、如何实现组播，具体怎么操作？

* 发送端目的IP使用组播IP,且指定端口。
* 所在网段的其他主机注册了该组播IP和对应端口即可接收消息。



# 四、TCP通信-快速入门

## 1、编写客户端代码

### 1.1 TCP协议回顾：

* TCP是一种**面向连接，安全、可靠**的传输数据的协议
* 传输前，采用“三次握手”方式，**点对点通信**，是可靠的

* 在连接中可进行大数据量的传输

> **TCP通信模型演示：**

![](https://pic1.imgdb.cn/item/635785f816f2c2beb15ed9ad.jpg)

* 注意：在java中只要是使用java.net.Socket类实现通信，底层即是使用了TCP协议

### 1.2 Scoket构造器 和 成员方法

* **构造器**

|                构造器                 |                             说明                             |
| :-----------------------------------: | :----------------------------------------------------------: |
| public Scoket(String host , int port) | 创建发送端的Scoket对象与服务端连接，参数为服务端程序的ip和端口 |

* **成员方法**

|              方法              |        说明        |
| :----------------------------: | :----------------: |
| Outputstream getoutputstream() | 获得字节输出流对象 |
|  Inputstream getInputstream()  | 获得字节输入流对象 |

### 1.3 案例分析

> **客户端发送消息 步骤：**

* 需求：客户端实现步骤
* ① 创建客户端的Socket对象，请求与服务端的连接。
* ② 使用socket对象调用getOutputStream()方法得到字节输出流。
* ③ 使用字节输出流完成数据的发送。
* ④ 释放资源：关闭socket管道。

### 1.4 idea 代码实现

```java
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *  目标：完成Socket网络编程入门案例的客户端开发，实现1发1收
 */
public class ClientDemo1 {
    public static void main(String[] args) {
        try {
            // 1、创建Socket通信管道清秀有服务端的连接
            // public Socket(String host, int port)
            // 参数一：服务器的IP地址
            // 参数二：服务器的端口
            Socket socket = new Socket("192.168.43.173",7777);

            // 2、从Socket通信管道中得到一个字节输出流，负责发送数据
            OutputStream os = socket.getOutputStream();

            // 3、把低级的字节流包装成打印流
            PrintStream ps = new PrintStream(os);

            // 4、发送消息
            ps.print("我是TCP的客户端，我已经与你对接，并发出邀请：约吗？");
            ps.flush();

            // 关闭资源
//            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 1.5 总结

> 1、TCP通信的客户端的代表类是谁？

* Socket类
* public Socket(String host,int port)

> 2、TCP通信如何使用Socket管道发送、接收数据。

* OutputStream getOutputStream0:获得字节输出流对象（发）
* Inputstream getinputstream0:获得字节输入流对象（收）



## 2、编写服务端代码、原理分析

### 2.1 SeverSocket 构造器 和 成员方法

* **构造器**

|             构造器              |      说明      |
| :-----------------------------: | :------------: |
| public ServerSocket( int port ) | 注册服务端端口 |

* **成员方法**

|          方法          |                             说明                             |
| :--------------------: | :----------------------------------------------------------: |
| public Socket accept() | 等待接收客户端的Socket:通信连接连接成功返回Socket对象与客户端建立端到端通信 |

### 2.2 idea代码实现

> **服务端代码：**

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  目标：开发Socket网络编程入门代码的服务端，实现接收消息
 */
public class ServerDemo2 {
    public static void main(String[] args) {
        try {
            System.out.println("=====服务端启动=====");
            // 1、注册端口
            ServerSocket serverSocket = new ServerSocket(7777);
            // 2、必须调用accept方法:等待接收客户端的Socket连接请求，建立Socket通信管道
            Socket socket = serverSocket.accept();
            // 3、从socket通信管道中得到一个字节输入流
            InputStream is = socket.getInputStream();
            // 4、将字节输入流包装成缓冲字符输入流进行消息的接收
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            // 5、按照行读取消息
            String msg;
            if ((msg = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

> **客户端代码：**

```java
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *  目标：完成Socket网络编程入门案例的客户端开发，实现1发1收
 */
public class ClientDemo1 {
    public static void main(String[] args) {
        System.out.println("=======客户端启动=======");
        try {
            // 1、创建Socket通信管道清秀有服务端的连接
            // public Socket(String host, int port)
            // 参数一：服务器的IP地址
            // 参数二：服务器的端口
            Socket socket = new Socket("192.168.43.173",7777);

            // 2、从Socket通信管道中得到一个字节输出流，负责发送数据
            OutputStream os = socket.getOutputStream();

            // 3、把低级的字节流包装成打印流
            PrintStream ps = new PrintStream(os);

            // 4、发送消息
            ps.println("我是TCP的客户端，我已经与你对接，并发出邀请：约吗？");
            ps.flush();

            // 关闭资源
//            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 2.3 总结

> 1、TCP通信服务端用的代表类？

* ServerSocket类，注册端口。
* 调用accept()方法阻塞等待接收客户端连接。得到Socket对象。

> 2、TCP通信的基本原理？

* 客户端怎么发，服务端就应该怎么收。
* 客户端如果没有消息，服务端会进入阻塞等待。
* Socket一方关闭或者出现异常、对方Socket也会失效或者出错。



# 五、TCP通信-多发多收

## 1、TCP通信-多发多收消息

> **案例分析**

* 需求：使用TCP通信方式实现：多发多收消息。
* 具体要求：
  * ① 可以使用死循环控制服务端收完消息继续等待接收下一个消息。
  * ② 客户端也可以使用死循环等待用户不断输入消息。
  * ③ 客户端一旦输入了exit,则关闭客户端程序，并释放资源。

### 1.1 idea代码实现

> **服务端代码：**

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  目标：开发Socket网络编程入门代码的服务端，实现接收消息
 */
public class ServerDemo2 {
    public static void main(String[] args) {
        try {
            System.out.println("=====服务端启动=====");
            // 1、注册端口
            ServerSocket serverSocket = new ServerSocket(7777);
            // 2、必须调用accept方法:等待接收客户端的Socket连接请求，建立Socket通信管道
            Socket socket = serverSocket.accept();
            // 3、从socket通信管道中得到一个字节输入流
            InputStream is = socket.getInputStream();
            // 4、将字节输入流包装成缓冲字符输入流进行消息的接收
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            // 5、按照行读取消息
            String msg;
            while ((msg = br.readLine()) != null){
                if ("exit".equals(msg)){
                    System.out.println("已离线");
                    socket.close();
                }
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
```

> **客户端代码：**

```java
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *  目标：完成Socket网络编程入门案例的客户端开发，实现多发多收
 */
public class ClientDemo1 {
    public static void main(String[] args) {
        System.out.println("=======客户端启动=======");
        try {
            // 1、创建Socket通信管道清秀有服务端的连接
            // public Socket(String host, int port)
            // 参数一：服务器的IP地址
            // 参数二：服务器的端口
            Socket socket = new Socket("192.168.43.173",7777);

            // 2、从Socket通信管道中得到一个字节输出流，负责发送数据
            OutputStream os = socket.getOutputStream();

            // 3、把低级的字节流包装成打印流
            PrintStream ps = new PrintStream(os);

            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("请说：");
                String msg = sc.nextLine();
                // 4、发送消息
                ps.println(msg);
                ps.flush();
            }

            // 关闭资源
//            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 1.2 问题引入

> **本案例实现了多发多收，那么是否可以同时接收多个客户端的消息？**

* 不可以的。
* 因为服务端现在只有一个线程，只能与一个客户端进行通信。

### 1.3 总结

> **1、本次多发多收是如何实现的**

* 客户端使用循环反复地发送消息。
* 服务端使用循环反复地接收消息。

> **2、现在服务端为什么不可以同时接收多个客户端的消息。**

* 目前服务端是单线程的，每次只能处理一个客户端的消息。



## 2、TCP通信-同时接受多个客户端消息[重点]

### 2.1 问题引入

> **1、之前我们的通信是否可以同时与多个客户端通信，为什么？**

* **不可以的**
* **单线程每次只能处理一个客户端的Socketi通信**

> **2、如何才可以让服务端可以处理多个客户端的通信需求？**

* 引入多线程

### 2.2 架构图

![](https://pic1.imgdb.cn/item/635796f116f2c2beb176017f.jpg)

### 2.3 idea代码实现

> **服务端代码：**

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  目标：实现服务端可以同时处理多个客户端的消息
 */
public class ServerDemo2 {
    public static void main(String[] args) {
        try {
            System.out.println("=====服务端启动=====");
            // 1、注册端口
            ServerSocket serverSocket = new ServerSocket(7777);
            // a.定义一个死循环由主线程负责不断的接收客户端的Socket管道连接
            while (true) {
                // 2、每接收到一个客户端的Socket管道，交给一个独立的子线程负责读取消息
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "上线了！");
                // 3、开始创建独立线程处理socket
                new ServerReaderThread(socket).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

> **线程类代码：**

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReaderThread extends Thread{
    private Socket socket;
    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            // 3、从socket通信管道中得到一个字节输入流
            InputStream is = socket.getInputStream();
            // 4、将字节输入流包装成缓冲字符输入流进行消息的接收
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            // 5、按照行读取消息
            String msg;
            while ((msg = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + msg);
            }
        } catch (IOException e) {

            System.out.println(socket.getRemoteSocketAddress() + "下线了！");
        }
    }
}
```

### 2.4 总结

> 1、本次是如何实现服务端接收多个客户端的消息的。

* 主线程定义了循环负责接收客户端Socket管道连接
* 每接收到一个Socketi通信管道后分配一个独立的线程负责处理它。



# 六、TCP-使用线程池优化

## 1、问题引入

> **目前的通信架构存在什么问题？**

* **客户端与服务端的线程模型是：N-N的关系。**
* **客户端并发越多，系统瘫痪的越快。**

## 2、引入线程池处理多个客户端消息

![](https://pic1.imgdb.cn/item/6357a4b416f2c2beb18a8c37.jpg)

## 3、代码实现

> **客户端代码：**

```java
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *  目标：使用线程池优化：实现通信。
 */
public class ClientDemo1 {
    public static void main(String[] args) {
        System.out.println("=======客户端启动=======");
        try {
            // 1、创建Socket通信管道清秀有服务端的连接
            // public Socket(String host, int port)
            // 参数一：服务器的IP地址
            // 参数二：服务器的端口
            Socket socket = new Socket("192.168.43.173",7777);

            // 2、从Socket通信管道中得到一个字节输出流，负责发送数据
            OutputStream os = socket.getOutputStream();

            // 3、把低级的字节流包装成打印流
            PrintStream ps = new PrintStream(os);

            Scanner sc = new Scanner(System.in);
            while (true){
                System.out.println("请说：");
                String msg = sc.nextLine();
                // 4、发送消息
                ps.println(msg);
                ps.flush();
            }

            // 关闭资源
//            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

> **服务端代码：**

```java
import com.study.d8_socket3.ServerReaderThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 *  目标：目标：使用线程池优化：实现通信。
 */
public class ServerDemo2 {

    // 使用静态变量记住一个线程池对象
    private static ExecutorService pool = new ThreadPoolExecutor(3,
            5, 6, TimeUnit.SECONDS,new ArrayBlockingQueue<>(2),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        try {
            System.out.println("=====服务端启动=====");
            // 1、注册端口
            ServerSocket serverSocket = new ServerSocket(7777);
            // a.定义一个死循环由主线程负责不断的接收客户端的Socket管道连接
            while (true) {
                // 2、每接收到一个客户端的Socket管道，交给一个独立的子线程负责读取消息
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "上线了！");
                // 任务对象负责读取消息
                Runnable target = new ServerReaderRunnable(socket);
                pool.execute(target);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

> **MyRunnable线程池实现类：**

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerReaderRunnable implements Runnable{
    private Socket socket;
    public ServerReaderRunnable(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            // 3、从socket通信管道中得到一个字节输入流
            InputStream is = socket.getInputStream();
            // 4、将字节输入流包装成缓冲字符输入流进行消息的接收
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            // 5、按照行读取消息
            String msg;
            while ((msg = br.readLine()) != null){
                System.out.println(socket.getRemoteSocketAddress() + "说了：" + msg);
            }
        } catch (IOException e) {

            System.out.println(socket.getRemoteSocketAddress() + "下线了！");
        }
    }
}
```

## 4、总结

> 1、本次使用线程池的优势在哪里？

* 服务端可以复用线程处理多个客户端，可以避免系统瘫痪。
* **适合客户端通信时长较短的场景。**