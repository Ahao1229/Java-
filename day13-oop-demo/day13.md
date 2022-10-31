# 一、单元测试

## 1、单元测试概述

### 1.1 单元测试

* 单元测试就是针对最小的功能单元编写测试代码，Java程序最小的功能单元是方法，因此，单元测试就是针对java方法的测试，进而检查方法的正确性。

> 目前测试方法是怎么进行的，存在什么问题

* 只有一个main方法，如果一个方法的测试失败了，其他方法测试会受到影响。
* 无法得到测试的结果报告，需要程序员自己去观察测试是否成功。

* 无法实现自动化测试

### 1.2 Junit单元测试框架

* JUnit是使用ava语言实现的单元测试框架，它是开源的，Java开发者都应当学习并使用JUnit编写单元测试。
* 此外，几乎所有的1DE工具都集成了JUnit,这样我们就可以直接在IDE中编写并运行Unit测试，JUnit目前最新版本是5。

> Junit优点

* JUit可以灵活的选择执行哪些测试方法，可以一键执行全部测试方法。
* Junit可以生成全部方法的测试报告。
* 单元测试中的某个方法测试失败了，不会影响其他测试方法的测试。

### 1.3 总结

> 1、Junit单元测试是做什么的？

* 测试类中方法的正确性的。

> 2、Junit单元测试的优点是什么？

* Junit可以选择执行哪些测试方法，可以一键执行全部测试方法的测试。
* Junit可以生测试报告，如果测试良好则是绿色；如果测试失败，则是红色。
* 单元测试中的某个方法测试失败了，不会影响其他测试方法的测试。



## 2、单元测试快速入门

### 2.1 步骤分析

* 需求：使用单元测试进行业务方法预期结果、正确性测试的快速入门
* 分析：
  * ① 将Unit的jar包导入到项目中
    * IDEA通常整合好了Junit框架，一般不需要导入。
    * 如果IDEA没有整合好，需要自己手工导入如下2个Unit的jar包到模块
  * ② 编写测试方法：该测试方法必须是公共的无参数无返回值的非静态方法。
  * ③ 在测试方法上使用@Test注解：标注该方法是一个测试方法
  * ④ 在测试方法中完成被测试方法的预期正确性测试。
  * ⑤ 选中测试方法，选择Junit运行”，如果测试良好则是绿色；如果测试失败，则是红色

### 2.2 代码实现

> 业务方法UserServer类：

```java
public class UserService {
    public String loginName(String loginName , String passWord){
        if ("admin".equals(loginName) && "123456".equals(passWord)){
            return "登录成功";
        }else {
            return "登录失败";
        }
    }

    public void selectNames(){
        System.out.println(10 / 0);
        System.out.println("查询全部用户名称成功！！");
    }
}
```

> 单元测试TestUserServer类：

```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 测试类
 */
public class TestUserService {
    /**
     * 测试方法
     * 注意点：
     *          1、必须公开的，无参数，无返回值的方法
     *          2、测试方法必须使用@Test注解标记
     */
    @Test
    public void testLoginName(){
        UserService userService = new UserService();
        String rs = userService.loginName("admin","123456");

        // 进行预期结果的正确性测试：断言。
        Assertions.assertEquals("登录成功", rs, "您的程序出现BUG");

    }

    @Test
    public void testSelectNames(){
        UserService userService = new UserService();
        userService.selectNames();

    }
```

### 2.3 总结

> 1、JUnit单元测试的实现过程是什么样的？

* 必须导入Junit框架的jar包。
* 定义的测试方法必须是无参数无返回值，且公开的方法。
* 测试方法使用@Test注解标记。

> 2、JUit测试某个方法，测试全部方法怎么处理？成功的标志是什么

* 测试某个方法直接右键该方法启动测试。
* 测试全部方法，可以选择类或者模块启动。
* 红色失败，绿色通过。



## 3、单元测试常用注解

### 3.1 Junit常用注解（以Junit 4.xxx 版本为例）

|     注解     |                             说明                             |
| :----------: | :----------------------------------------------------------: |
|    @Test     |                           测试方法                           |
|   @Before    | 用来修饰实例方法，该方法会在每一个测试方法执行之前执行一次。 |
|    @After    | 用来修饰实例方法，该方法会在每一个测试方法执行之后执行一次。 |
| @BeforeClass |   用来静态修饰方法，该方法会在所有测试方法之前只执行一次。   |
| @Afterclass  |   用来静态修饰方法，该方法会在所有测试方法之后只执行一次。   |

* 开始执行的方法：初始化资源。
* 执行完之后的方法：释放资源。

### 3.2 Junit常用注解（以Junit 5.xxx 版本为例）

|    注解     |                             说明                             |
| :---------: | :----------------------------------------------------------: |
|    @Test    |                           测试方法                           |
| @BeforeEach | 用来修饰实例方法，该方法会在每一个测试方法执行之前执行一次。 |
| @AfterEach  | 用来修饰实例方法，该方法会在每一个测试方法执行之后执行一次。 |
| @BeforeAll  |   用来静态修饰方法，该方法会在所有测试方法之前只执行一次、   |
|  @AfterAll  |   用来静态修饰方法，该方法会在所有测试方法之后只执行一次。   |

* 开始执行的方法：初始化资源。
* 执行完之后的方法：释放资源。



# 二、反射

## 1、反射概述

### 1.1 反射概述

* 反射是指对于任何一个Clss类，在"运行的时候"都可以直接得到这个类全部成分。
* 在运行时，可以直接得到这个类的构造器对象：Constructor
* 在运行时，可以直接得到这个类的成员变量对象：Field
* 在运行时，可以直接得到这个类的成员方法对象：Method
* 这种运行时动态获取类信息以及动态调用类中成分的能力称为Java语言的反射机制。

### 1.2 反射的关键

* 反射的第一步都是先得到编译后的Class类对象，然后就可以得到Class的全部成分。

### 1.3 总结

> 反射的基本作用、关键？

* 反射是在运行时获取类的字节码文件对象：然后可以解析类中的全部成分。
* 反射的核心思想和关键就是：得到编译以后的clss文件对象。



## 2、反射获取类对象

### 2.1 反射第一步：获取Class类的对象

![](https://pic1.imgdb.cn/item/635a47ef16f2c2beb1edf3a1.jpg)

![](https://pic1.imgdb.cn/item/635a497616f2c2beb1f321fd.jpg)

### 2.2 代码实现

```java
public class Test {
    public static void main(String[] args) throws Exception {
        // 1、Class类中的一个静态方法:forName(全限名：包名 + 类名)
        Class c = Class.forName("com.study.d2_reflect_class.Student");
        System.out.println(c); // Student.class

        // 2、类名.class
        Class c1 = Student.class;
        System.out.println(c1);

        // 3、对象.getClass() 获取对象对应类的Class对象。
        Student s = new Student();
        Class c2 = s.getClass();
        System.out.println(c2);

    }
}
```

### 2.3 总结

> 1、反射的第一步是什么？

* 获取Class类对象，如此才可以解析类的全部成分

> 2、获取Class:类的对象的三种方式

* 方式-：Class c1=Class.forName(“全类名”)：
* 方式二：Class c2=类名.class
* 方式三：Class c3=对象.getClass0;



## 3、反射获取构造器对象

### 3.1 使用反射技术获取构造器对象并使用

![](https://pic1.imgdb.cn/item/635b94be16f2c2beb1115999.jpg)

* 反射的第一步是先得到类对象，然后从类对象中获取类的成分对象。
* Class类中用于获取构造器的方法

|                             方法                             |                    说明                    |
| :----------------------------------------------------------: | :----------------------------------------: |
|            Constructor<?>[ ]  getConstructors( )             | 返回所有构造器对象的数组（只能拿public的） |
|        Constructor<?>[ ]  getDeclaredConstructors( )         |   返回所有构造器对象的数组，存在就能拿到   |
|  Constructor<T>  getConstructor(Class<?>... parameterTypes)  |    返回单个构造器对象（只能拿public的）    |
| Constructor<T>  getDeclaredConstructor(Class<?>... parameterTypes) |      返回单个构造器对象，存在就能拿到      |

* Constructor类中用于创建对象的方法

|                  符号                   |                   说明                    |
| :-------------------------------------: | :---------------------------------------: |
|    T newInstance(Object... initargs)    |         根据指定的构造器创建对象          |
| public void setAccessible(boolean flag) | 设置为true,表示取消访问检查，进行暴力反射 |



###  3.2 idea代码实现

> Student类：

```java
public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("无参构造器执行");
    }

    public Student(String name, int age) {
        System.out.println("有参构造器执行");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", age=" + age +
                '}';
    }
}
```

> TestStudent类：

```java
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

public class TestStudent1 {
    // 1、getConstructors:
    // 获取全部的构造器：只能获取public修饰的构造器。
    // Constructor[]getConstructors()
    @Test
    public void getConstructors(){
        // a. 第一步：获取类对象
        Class c = Student.class;
        // b. 提取类中全部的构造器对象(只能拿public修饰的)
        Constructor[] constructors = c.getConstructors();
        // c. 遍历构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "=======>" + constructor.getParameterCount());
        }
        System.out.println("----------------------------------------");
    }

    // 2、getDeclaredConstructors():
    // 获取全部的构造器：只要你敢写，这里就能拿到，无所谓权限是否可及。
    @Test
    public void getDeclaredConstructors(){

        // a. 第一步：获取类对象
        Class c = Student.class;
        // b. 提取类中全部的构造器对象
        Constructor[] constructors = c.getDeclaredConstructors();
        // c. 遍历构造器
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + "=======>" + constructor.getParameterCount());
        }
        System.out.println("----------------------------------------");
    }

    // 3、getConstructor(Class...parameterTypes)
    // 获取某个构造器：只能拿public修饰的某个构造器
    @Test
    public void getConstructor() throws Exception {
        // a. 第一步：获取类对象
        Class c = Student.class;
        // b. 定位单个构造器对象(按照参数定位无参数构造器)
        Constructor cons = c.getConstructor();
        System.out.println(cons.getName() + "=======>" + cons.getParameterCount());
        System.out.println("----------------------------------------");
    }

        // 4、getDeclaredConstructor
        // 获取某个构造器：只要你敢写，这里就能拿到，无所谓权限是否可及。
        @Test
        public void getDeclaredConstructor() throws Exception {
            // a. 第一步：获取类对象
            Class c = Student.class;
            // b. 定位单个构造器对象(按照参数定位无参数构造器)
            Constructor cons = c.getDeclaredConstructor();
            System.out.println(cons.getName() + "=======>" + cons.getParameterCount());

            // c. 定位某个有参构造器
            Constructor cons1 = c.getDeclaredConstructor(String.class, int.class);
            System.out.println(cons1.getName() + "=======>" + cons1.getParameterCount());



            System.out.println("----------------------------------------");
        }

}
```

> TestStudent2类：

```java
public class TestStudent2 {
    // 1、调用构造器得到一个类的对象返回
    @Test
    public void getDeclaredConstructor() throws Exception {
        // a. 第一步：获取类对象
        Class c = Student.class;
        // b. 定位单个构造器对象(按照参数定位无参数构造器)
        Constructor cons = c.getDeclaredConstructor();
        System.out.println(cons.getName() + "=======>" + cons.getParameterCount());

        // 如果遇到了私有的构造器，可以暴力反射
        cons.setAccessible(true);   // 权限被打开

        Student s = (Student) cons.newInstance();
        System.out.println(s);

        System.out.println("--------------");


        // c. 定位某个有参构造器
        Constructor cons1 = c.getDeclaredConstructor(String.class, int.class);
        System.out.println(cons1.getName() + "=======>" + cons1.getParameterCount());

        Student s1 = (Student) cons1.newInstance("孙悟空",1000);
        System.out.println(s1);
    }
}
```

### 3.3 总结

> 1、利用反射技术获取构造器对象的方式

* getDeclaredConstructors()
* getDeclaredConstructor(Class<?>...parameterTypes)

> 2、反射得到的构造器可以做什么？

* **依然是创建对象的**
  * public newlnstance(object...initargs)
* **如果是非public的构造器，需要打开权限（暴力反射），然后再创建对象**
  * setAccessible(boolean)
  * **反射可以破坏封装性，私有的也可以执行了。**



## 4、反射获取成员变量对象

### 4.1 反射如何获取成员变量对象

* 反射的第一步是先得到类对象，然后从类对象中获取类的成分对象。
* Class类中用于获取成员变量的方法

|                  方法                  |                    说明                    |
| :------------------------------------: | :----------------------------------------: |
|          Filed[] getField ()           | 返回所有成员变量对象的数组（只能拿public） |
|      Field[] getDeclaredFields ()      |    返回所有成员变量的数组，存在就能拿到    |
|     Field getField ( String name )     |   返回单个成员变量对象 （只能拿public）    |
| Field getDeclaredField ( String name ) |       返回单个成员变量，存在就能拿到       |

* 获取成员变量的作用依然是在某个对象中取值、赋值



* Field类中用于取值、赋值的方法

| 符号                                 | 说明   |
| ------------------------------------ | ------ |
| void set( Object obj, Object value ) | 赋值   |
| Object get ( Object obj )            | 获取值 |

### 4.2 idea代码实现

> Student类：

```java
public class Student {
    private String name;
    private int age;
    public static String schoolName;
    public static final String COUNTTRY = "CHINA";

    public Student() {
        System.out.println("无参构造器执行！");
    }

    public Student(String name, int age) {
        System.out.println("有参构造器执行");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", age=" + age +
                '}';
    }
}
```

> FieldDemo1：

```java
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class FieldDemo1 {

    /**
     *  1、获取全部的成员变量。
     *  Field[] getDeclaredFields();
     *  获得所有的成员变量对象对应的Field对象，只要申明了就可以得到
     */
    @Test
    public void getDeclaredFields(){
        // a.定位Class对象
        Class c = Student.class;
        // b.定位全部成员变量
        Field[] fields = c.getDeclaredFields();
        // c.遍历一下
        for (Field field : fields) {
            System.out.println(field.getName() + "===>" + field.getType());
        }
        System.out.println("--------------------------------");
    }

    /**
     *  2、获取某个成员变量
     */
    @Test
    public void getDeclaredField() throws Exception {
        // a.定位Class对象
        Class c = Student.class;
        // b.根据名称定位某个成员变量
        Field f = c.getDeclaredField("age");
        System.out.println(f.getName() + "===>" + f.getType());

    }
}
```

> FieldDemo2：

```java
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

/**
 * Field的方法：给成员变量赋值和取值
 * void set(Object obj,Object value):给对象注入某个成员变量数据
 * Object get(Object obj):获取对象的成员变量的值。
 * void setAccessible(trUe);暴力反射，设置为可以直接访问私有类型的属性。
 * Class getType();获取属性的类型，返回class对象。
 * String getName();获取属性的名称。
 */
public class FieldDemo2 {
    @Test
    public void setField() throws Exception{
        // a.反射第一步，获取类对象
        Class c = Student.class;
        // b.提取某个成员变量
        Field ageF = c.getDeclaredField("age");
        ageF.setAccessible(true);   // 暴力打开权限

        // c.赋值
        Student s = new Student();
        ageF.set(s , 18);   // s.setAge(18)
        System.out.println(s);

        // d.取值
        int age = (int)ageF.get(s);
        System.out.println(age);


    }
}
```

### 4.3 总结

> 1.利用反射技术获取成员变量的方式

* 获取类中成员变量对象的方法
  * getDeclaredFields()
  * getDeclaredField (String name)

> 2.反射得到成员变量可以做什么？

* 依然是在某个对象中取值和赋值。
  * void set(Object obj,Object value):
  * Object get(object obj)

* 如果某成员变量是非pubc的，需要打开权限（暴力反射），然后再取值、赋值
  * setAccessible(boolean)



## 5、反射获取方法对象

### 5.1 如何使用反射获取方法对象

> 反射的第一步是先得到类对象，然后从类对象中获取类的成分对象。

* Class类中用于获取成员方法的方法

| 方法                                                         | 说明                                         |
| ------------------------------------------------------------ | -------------------------------------------- |
| Method[] getMethods( )                                       | 返回所有成员方法对象的数组（只能拿public的） |
| Method[] getDeclaredMethods( )                               | 返回所有成员方法的数组，存在就能拿到         |
| Method getMethod ( String name, Class<?>... parameterTypes ) | 返回单个成员方法对象（只能拿public的）       |
| Method getDeclaredMethod( String name, Class<?>... parameterTypes ) | 返回单个成员方法对象，存在就能拿到           |

> 获取成员方法的作用依然是在某个对象中进行执行此方法

* Method类中用于触发执行的方法

| 符号                                       | 说明                                                         |
| ------------------------------------------ | ------------------------------------------------------------ |
| Object invoke( Object obj, Object... args) | 运行方法<br/>参数一：用obj对象调用该方法<br/>参数二：调用方法的传递的参数（如果没有就不写）<br/>返回值：方法的返回值（如果没有就不写） |

### 5.2 idea代码实现

> Dog类：

```java
public class Dog {
    public String name;
    public Dog(){
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run(){
        System.out.println("狗跑的贼快~~");
    }

    private void eat(){
        System.out.println("狗贼能吃肉~~");
    }

    private String eat(String name){
        System.out.println("狗吃" + name);
        return "狗吃的巨TM的开心";
    }

    public static void inAddr(){
        System.out.println("不会真有人是单身狗吧！");
    }

}
```

> MethodDemo1：

```java
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public class MethodDemo1 {
    /**
     *  1、获得类中的所有成员方法对象
     */
    @Test
    public void getDeclaredMethods(){
        // a.获取类对象
        Class c = Dog.class;
        // b.提取全部方法，包括私有
        Method[] methods = c.getDeclaredMethods();
        // c.遍历全部方法
        for (Method method : methods) {
            System.out.println(method.getName() + " 返回值类型：" + method.getReturnType() +
            " 参数名称：" + method.getParameterCount());
        }
    }

    /**
     *  2、获取某个方法对象
     */
    @Test
    public void getDeclaredMethod() throws Exception{
        // a.获取类对象
        Class c = Dog.class;
        // b.提取单个方法对象
        Method m = c.getDeclaredMethod("eat");
        Method m2 = c.getDeclaredMethod("eat", String.class);

        // 暴力打开权限
        m.setAccessible(true);
        m2.setAccessible(true);

        // c.触发方法的执行
        Dog d = new Dog();
        // 注意没有结果返回回来的话，返回null
        Object result = m.invoke(d);
        System.out.println(result);

        Object result2 = m2.invoke(d,"肉");
        System.out.println(result2);
    }

}
```

### 5.3 总结

> 1、利用反射技术获取成员方法对象的方式

* 获取类中成员方法对象
  * getDeclaredMethods()
  * getDeclaredMethod (String name,Class<?>...parameterTypes)

> 2、反射得到成员方法可以做什么？

* 依然是在某个对象中触发该方法执行。
  * object invoke(object obj,object...args)

* 如果某成员方法是非public的，需要打开权限（暴力反射），然后再触发执行



## 6、反射的作用-绕过编译阶段为集合添加数据

### 6.1 什么是绕过编译阶段为集合添加数据

* 反射是作用在运行时的技术，此时集合的泛型将不能产生约束了，此时是可以**为集合存入其他任意类型的元素的**。
* 泛型只是在编译阶段可以约束集合只能操作某种数据类型，**在编译成Class文件进入运行阶段**的时候，其真实类型都是
  ArrayList了，泛型相当于被擦除了。

### 6.2 idea代码实现

> ReflectDemo:

```java
import java.lang.reflect.Method;
import java.util.ArrayList;

public class ReflectDemo {
    public static void main(String[] args) throws Exception{
        // 需求：反射实现泛型擦除后，加入其他类型的元素
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        System.out.println(list1.getClass());
        System.out.println(list2.getClass());

        System.out.println(list1.getClass() == list2.getClass()); // ArrayList.class

        System.out.println("-----------------------------");
        list2.add(23);
        list2.add(22);
        // list2.add("你好");

        Class c = list2.getClass();
        // 定位c类中的add方法
        Method add = c.getDeclaredMethod("add", Object.class);
        boolean rs = (Boolean) add.invoke(list2, "你好");
        System.out.println(rs);
        System.out.println(list2);
        
    }
}
```

> 运行结果：

![](https://pic1.imgdb.cn/item/635fb03c16f2c2beb1bda9ff.jpg)

### 6.3 总结

> 反射为何可以给约定了泛型的集合存入其他类型的元素？

* **编译成Class文件进入运行阶段的时候，泛型会自动擦除。**
* 反射是作用在运行时的技术，此时已经不存在泛型了。



## 7、反射的作用-通用框架的底层原理

### 7.1 案例分析

> 反射做通用框架

* 需求：
  * 给你任意一个对象，在不清楚对象字段的情况可以把对象的字段名称和对应值存储到文件中去

![](https://pic1.imgdb.cn/item/635fb16e16f2c2beb1c0c414.jpg)

* 分析：
  * ① 定义一个方法，可以接受任意类的对象
  * ② 每次收到一个对象后，需要解析到这个对象的全部变量名称
  * ③ 这个对象可能是任意的，那么怎么样才可以知道这个对象的全部成员变量名称呢？
  * ④ 使用反射获取对象的Cl5s类对象，然后获取全部成员变量信息。
  * ⑤ 遍历成员变量信息，然后提取本成员变量在对象中的具体值
  * ⑥ 存入成员变量名称和值到文件中去即可。

### 7.2 idea代码实现

> Student类：

```java
public class Student {
    private String name;
    private char sex;
    private int age;
    private String className;
    private String hobby;

    public Student() {
    }

    public Student(String name, char sex, int age, String className, String hobby) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.className = className;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
```

> Teacher类：

```java
public class Teacher {
    private String name;
    private char sex;
    private double salary;

    public Teacher() {
    }

    public Teacher(String name, char sex, double salary) {
        this.name = name;
        this.sex = sex;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
```

> MybatisUtil通用框架：

```java
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class MybatisUtil {
    /**
     * 保存任意类型的对象
     * @param obj
     */
    public static void save(Object obj) {
        try(
                FileOutputStream os = new FileOutputStream("day13-oop-demo/src/date.txt",true);
                PrintStream ps = new PrintStream(os);
             ) {

            // 1、提取这个对象的全部成员变量：只有反射可以解决
            Class c =obj.getClass(); //(c.getSimpleName()获取当前类名  c.getName获取全限名：包名+类
            ps.println("=============="+c.getSimpleName()+"==============");
            // 2、提取全部成员变量
            Field[] fields = c.getDeclaredFields();
            // 3、获取成员变量的信息
            for (Field field : fields) {
                String name = field.getName();
                field.setAccessible(true);
                // 提取本成员变量再obj对象中的值（取值）
                String value = field.get(obj) + "";
                ps.println(name + " = " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

> ReflectDemo类：

```java
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Student s = new Student();
        s.setName("贾四");
        s.setClassName("学习1班");
        s.setAge(20);
        s.setHobby("美女，美女和美女");
        s.setSex('男');
        MybatisUtil.save(s);

        Teacher t = new Teacher();
        t.setName("美女老师");
        t.setSex('女');
        t.setSalary(100000000.0);
        MybatisUtil.save(t);


    }
}
```

> 运行结果：

![](https://pic1.imgdb.cn/item/635fb7ec16f2c2beb1d38f0e.jpg)

### 7.3 总结

> 反射的作用

* 可以在运行时得到一个类的全部成分然后操作。
* 可以破坏封装性。（很突出）
* 也可以破坏泛型的约束性。（很突出）
* 更重要的用途是适合：做Java高级框架

