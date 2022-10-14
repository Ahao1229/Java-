package com.study.run;

import com.study.Bean.Business;
import com.study.Bean.Customer;
import com.study.Bean.Movie;
import com.study.Bean.User;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MovieSystem {
    /**
     * 定义系统的数据容器用户存储数据
     * 1、存储很多用户（客户对象，商家对象）
     */
    public static final List<User> ALL_USERS = new ArrayList<>();
    /**
     * 键盘录入
     */
    public static final Scanner SYS_SC = new Scanner(System.in);
    /**
     * 定义一个静态的User类的变量记住当前登录的用户
     */
    public static User loginUser;
    public static final Logger logger = LoggerFactory.getLogger(MovieSystem.class);
    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    /**
     *  2、存储系统全部商家和其排片信息
     *      商家1 = [p1,p2,p3...]
     *      商家2 = [p1,p2,...]
     */
    public static Map<Business , List<Movie>> ALL_MOVIES = new HashMap<>();

    /**
     *  3、准备一些测试数据
     */
    static {
        Customer c = new Customer();
        c.setLoginName("lyf520");
        c.setPassWord("ljh521");
        c.setUserName("承德小仙女");
        c.setSex('女');
        c.setMoney(10000);
        c.setPhone("20200925");
        ALL_USERS.add(c);

        Business b = new Business();
        b.setLoginName("sddyy888");
        b.setPassWord("123456");
        b.setUserName("首都电影院");
        b.setMoney(0);
        b.setSex('男');
        b.setPhone("110120");
        b.setShopName("首都电影院");
        b.setAddress("悦荟广场顶层");
        ALL_USERS.add(b);
        // 注意：商家一定需要假如排片信息中
        List<Movie> movies = new ArrayList<>();
        ALL_MOVIES.put(b , movies);
    }

    public static void main(String[] args) {
        showMain();
    }

    /**
     *  首页展示
     */
    private static void showMain() {
        System.out.println("===============电影首页================");
        System.out.println("1、登录");
        System.out.println("2、用户注册");
        System.out.println("3、商家注册");
        while (true) {
            System.out.println("请输入操作命令");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    login();
                    break;
                case "2":
                    customerRegistered();
                    break;
                case "3":
                    businessRegistered();
                    break;
                default:
                    System.out.println("命令有误，请确认!");
            }
        }
    }

    /**
     * 商家注册
     */
    private static void businessRegistered() {
        System.out.println("============================商家注册界面==============================");
        Business c = new Business();
        System.out.println("请输入您的登录名：");
        String loginName = SYS_SC.nextLine();
        if (getUserByUserName(loginName) == null) {
            System.out.println("请输入您密码：");
            String passWord = SYS_SC.nextLine();
            System.out.println("请确认密码：");
            String passwd = SYS_SC.nextLine();
            if (passwd.equals(passWord)) {
                System.out.println("请输入您的真实姓名：");
                String userName = SYS_SC.nextLine();
                System.out.println("请输入您的性别：");
                String sex = SYS_SC.nextLine();
                System.out.println("请输入您要存多少钱：");
                String money = SYS_SC.nextLine();
                System.out.println("请输入您的手机号：");
                String phone = SYS_SC.nextLine();
                System.out.println("请输入您的影院名称：");
                String shopName = SYS_SC.nextLine();
                System.out.println("请输入您的地址：");
                String address = SYS_SC.nextLine();
                c.setPassWord(passWord);
                c.setLoginName(loginName);
                c.setUserName(userName);
                c.setSex(sex.charAt(0));
                c.setMoney(Double.valueOf(money));
                c.setPhone(phone);
                c.setShopName(shopName);
                c.setAddress(address);
                ALL_USERS.add(c);
                List<Movie> movies = new ArrayList<>();
                ALL_MOVIES.put(c , movies);
            } else {
                System.out.println("您两次输入的密码不一致");
            }
        }else {
            System.out.println("该用户已存在，请直接登录:");
        }
    }

    /**
     * 用户注册
     */
    private static void customerRegistered() {
        System.out.println("=======================用户注册界面=========================");
        Customer c = new Customer();
        System.out.println("请输入您的登录名：");
        String loginName = SYS_SC.nextLine();
        if (getUserByUserName(loginName) == null) {
            System.out.println("请输入您密码：");
            String passWord = SYS_SC.nextLine();
            System.out.println("请确认密码：");
            String passwd = SYS_SC.nextLine();
            if (passwd.equals(passWord)) {
                System.out.println("请输入您的真实姓名：");
                String userName = SYS_SC.nextLine();
                System.out.println("请输入您的性别：");
                String sex = SYS_SC.nextLine();
                System.out.println("请输入您要存多少钱：");
                String money = SYS_SC.nextLine();
                System.out.println("请输入您的手机号：");
                String phone = SYS_SC.nextLine();
                c.setPassWord(passWord);
                c.setLoginName(loginName);
                c.setUserName(userName);
                c.setSex(sex.charAt(0));
                c.setMoney(Double.valueOf(money));
                c.setPhone(phone);
                ALL_USERS.add(c);
            } else {
                System.out.println("您两次输入的密码不一致");
            }
        }else {
            System.out.println("该用户已存在，请直接登录:");
        }

    }

    /**
     * 登录功能
     */
    private static void login() {
        while (true) {
            System.out.println("请您输入登录名称:");
            String loginName = SYS_SC.nextLine();
            System.out.println("请你输入登录密码：");
            String passWord = SYS_SC.nextLine();

            // 1、根据登录名查询用户对象
            User u = getUserByUserName(loginName);
            // 2、判断用户对象是否存在
            if (u != null){
                // 3、比对密码是否正确
                if (u.getPassWord().equals(passWord)){
                    // 登录成功：
                    loginUser = u;
                    logger.debug(u.getUserName() + "登录了系统~~~");
                    // 判断用户登录的还是商家登录的。 判断类型
                    if (u instanceof Customer){
                        // 当前登录的是客户用户
                        showCustomerMain();
                    }else {
                        // 当前登录的是商家用户
                        showBusinessMain();
                    }
                }else {
                    System.out.println("密码错误");
                }
                return; // 用于破坏死循环While的
            }else {
                System.out.println("登录名称错误，请确认！");
            }
        }
    }

    /**
     *  商家操作界面
     */
    private static void showBusinessMain() {
        System.out.println("========电影商户界面=============");
        logger.debug("商家"+loginUser.getUserName() + "登录了系统~~~");
        System.out.println(loginUser.getUserName() + (loginUser.getSex() == '男' ? "先生" : "女士") + "欢迎您进入系统");
        System.out.println("1、展示详情：");
        System.out.println("2、上架电影：");
        System.out.println("3、下架电影：");
        System.out.println("4、修改电影：");
        System.out.println("5、退出：");
        while (true) {
            System.out.println("请输入要进行的操作");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    //  展示全部排片信息
                    showBusinessInfos();
                    break;
                case "2":
                    // 上架电影
                    addMovie();
                    break;
                case "3":
                    // 下架电影
                    deleteMovie();
                    break;
                case "4":
                    // 修改电影
                    updateMovie();
                    break;
                case "5":
                    System.out.println("欢迎下次光临!!");
                    return;
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    /**
     * 影片修改
     */
    private static void updateMovie() {
        System.out.println("===================电影修改功能=====================");
        Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        if (movies.size() == 0){
            System.out.println("当前没有影片可以修改");
            return;
        }
        while (true) {
            // 2、让用户选择需要修改的电影名称
            System.out.println("请您输入需要修改的电影名称");
            String movieName = SYS_SC.nextLine();

            // 3、查询有没有这个影片对象
            Movie movie = getMovieByName(movieName);
            if (movie != null){
                System.out.println("请您输入新片名：");
                String name = SYS_SC.nextLine();
                System.out.println("请您输入主演：");
                String actor = SYS_SC.nextLine();
                System.out.println("请您输入时长：");
                String time = SYS_SC.nextLine();
                System.out.println("请您输入票价：");
                String price = SYS_SC.nextLine();
                System.out.println("请您输入票数：");
                String totalNumber = SYS_SC.nextLine();

                System.out.println("请输入修改后的影片放映时间");
                String stime = SYS_SC.nextLine();
                movie.setName(name);
                movie.setActor(actor);
                movie.setPrice(Double.valueOf(price));
                movie.setTime(Double.valueOf(time));
                movie.setNumber(Integer.valueOf(totalNumber));
                System.out.println("修改影片成功");
                try {
                    movie.setStartTime(sdf.parse(stime));
                } catch (ParseException e) {
                    e.printStackTrace();
                    System.out.println("时间解析出现了问题");
                }


                System.out.println("您的影院已经成功修改" + movie.getName());
                return;
            }else {
                System.out.println("您的影院没有上架该影片");
                System.out.println("请问继续修改吗？y/n");
                String command = SYS_SC.nextLine();
                switch (command){
                    case "y":
                        break;
                    default:
                        return;
                }
            }
        }
    }

    /**
     *  影片下架
     */
    private static void deleteMovie() {
        System.out.println("===================电影下架功能=====================");
        Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        if (movies.size() == 0){
            System.out.println("当前没有影片可以删除");
            return;
        }
        while (true) {
            // 2、让用户选择需要下架的电影名称
            System.out.println("请您输入需要下架的电影名称");
            String movieName = SYS_SC.nextLine();

            // 3、查询有没有这个影片对象
            Movie movie = getMovieByName(movieName);
            if (movie != null){
                movies.remove(movie);
                System.out.println("您的影院已经成功下架" + movie.getName());
            }else {
                System.out.println("您的影院没有上架该影片");
                System.out.println("请问继续下架吗？y/n");
                String command = SYS_SC.nextLine();
                switch (command){
                    case "y":
                        break;
                    default:
                        return;
                }
            }
        }

    }

    /**
     *  根据电影名查询当前上架上映影片
     */
    private static Movie getMovieByName(String movieName) {
        Business business =  (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        for (Movie movie : movies) {
            if (movie.getName().contains(movieName)){
                return movie;
            }
        }
        return null;
    }


    /**
     * 上架电影
     */
    private static void addMovie() {
        System.out.println("====================电影上架功能====================");
        Business business = (Business) loginUser;
        List<Movie> movies = ALL_MOVIES.get(business);
        System.out.println("请您输入新片名：");
        String name = SYS_SC.nextLine();
        System.out.println("请您输入主演：");
        String actor = SYS_SC.nextLine();
        System.out.println("请您输入时长：");
        String time = SYS_SC.nextLine();
        System.out.println("请您输入票价：");
        String price = SYS_SC.nextLine();
        System.out.println("请您输入票数：");
        String totalNumber = SYS_SC.nextLine();
        while (true) {

            System.out.println("请您输入影片放映时间：");
            String stime = SYS_SC.nextLine();
            Movie movie = null;

            try {
                movie = new Movie(name , actor, Double.valueOf(time),Double.valueOf(price), Integer.valueOf(totalNumber),sdf.parse(stime));
            } catch (ParseException e) {
                e.printStackTrace();
                System.out.println("时间解析出现了问题");
            }


            movies.add(movie);
            System.out.println(movie.getName() + "已经成功上架");
            return;

        }
    }



    /**
     * 展示全部排片信息
     */
    private static void showBusinessInfos() {
        // 根据商家对象(loginUser就是登录的用户)，作为Map集合的键 提取对应的值就是其排片信息
        Business business = (Business) loginUser;
        System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone() + "\t\t地址" + business.getAddress());
        List<Movie> movies = ALL_MOVIES.get(loginUser);
        if (movies.size() > 0) {
            System.out.println("片名\t\t\t\t主演\t\t时长\t\t评分\t\t余票数量\t\t放映时间");
            for (Movie movie : movies) {
                System.out.println(movie.getName()+"\t\t\t"+movie.getActor()+"\t\t"+movie.getTime()+"\t\t"
                        + movie.getScore() + "\t\t" + movie.getPrice()+"\t\t" + movie.getNumber() + "\t\t"
                        + sdf.format(movie.getStartTime()) );
            }
        }else {
            System.out.println("该影院当前没有排片");
        }


    }


    /**
     * 客户操作界面
     */
    private static void showCustomerMain() {
        System.out.println("========电影客户界面=============");
        System.out.println(loginUser.getUserName() + (loginUser.getSex() == '男' ? "先生" : "女士") + "欢迎您进入系统");
        System.out.println("请您选择要操作的功能：");
        System.out.println("1、展示全部影片信息功能：");
        System.out.println("2、根据电影名称查询电影信息：");
        System.out.println("3、评分功能：");
        System.out.println("4、购票功能：");
        System.out.println("5、退出系统：");
        while (true) {
            System.out.println("请输入要进行的操作");
            String command = SYS_SC.nextLine();
            switch (command){
                case "1":
                    // 展示全部影片
                    showAllMovie();
                    break;
                case "2":
                    // 根据电影名称查询电影信息
                    break;
                case "3":
                    break;
                case "4":
                    // 购票功能
                    buyMovie();
                    break;
                case "5":
                    return;
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    /**
     * 用户购票功能  ALL_MOVIE = (b1 = [p1,p2,p3])
     */
    private static void buyMovie() {
        showAllMovie();
        System.out.println("=====================用户购票功能=====================");
        while (true) {
            System.out.println("请您输入需要买票的门店");
            String shopName = SYS_SC.nextLine();
            // 1、查询是否存在该商家
            Business business = getUserByShopName(shopName);
            if (business == null){
                System.out.println("对不起，该商铺不存在！");
            }else {
                // 2、此商家全部的排片
                List<Movie> movies = ALL_MOVIES.get(business);
                // 3、判断是否存在上映的电影
                if (movies.size() > 0){
                    // 4、开始进行选片购买
                    while (true) {
                        System.out.println("请输入需要购买的电影名称：");
                        String movieName = SYS_SC.nextLine();
                        // 去当前商家下，查询该电影
                        Movie movie = getMovieByShopAndName(business ,movieName);
                        if (movie != null){
                            // 开始购票
                            while (true) {
                                System.out.println("请输入要购买的电影票数");
                                String number = SYS_SC.nextLine();
                                int buyNumber = Integer.valueOf(number);
                                // 余票是否充足
                                if (movie.getNumber() >= buyNumber){
                                    // 可以购买
                                }else {
                                    System.out.println("票数不够,余票仅剩："+movie.getNumber());
                                    System.out.println("是否继续买票y/n");
                                    String command = SYS_SC.nextLine();
                                    switch (command){
                                        case "y":
                                            break;
                                        default:
                                            return;
                                    }
                                }
                            }
                        }else {
                            System.out.println("电影名称有问题");
                        }
                    }
                }else {
                    System.out.println("该电影院没有正在上映的电影");
                    System.out.println("是否继续买票y/n");
                    String command = SYS_SC.nextLine();
                    switch (command){
                        case "y":
                            break;
                        default:
                            return;
                    }
                }
            }
        }


    }

    /**
     * 根据电影名称和电影院名称查找电影
     */
    public static Movie getMovieByShopAndName(Business business , String name){
        List<Movie> movies = ALL_MOVIES.get(business);
        for (Movie movie : movies) {
            if (movie.getName().contains(name)){
                return movie;
            }
        }
        return null;
    }

    /**
     *  根据商家名称查询商家对象
     */
    public static Business getUserByShopName(String shopName){
        Set<Business> businesses = ALL_MOVIES.keySet();
        for (Business business : businesses) {
            if (business.getShopName().equals(shopName));
            {
                return business;
            }
        }
        return null;
    }

    /**
     *  展示全部商家和其排片信息
     */
    private static void showAllMovie() {
        System.out.println("==================展示全部商家排片信息=====================");
        ALL_MOVIES.forEach(((business, movies) -> {
            System.out.println(business.getShopName() + "\t\t电话：" + business.getPhone() + "\t\t地址" + business.getAddress());
            System.out.println("\t\t\t片名\t\t\t\t主演\t\t时长\t\t评分\t\t余票数量\t\t放映时间");
            for (Movie movie : movies) {
                System.out.println("\t\t\t"+movie.getName()+"\t\t\t"+movie.getActor()+"\t\t"+movie.getTime()+"\t\t"
                        + movie.getScore() + "\t\t" + movie.getPrice()+"\t\t" + movie.getNumber() + "\t\t"
                        + sdf.format(movie.getStartTime()) );
            }
        }));
    }


    /**
     * 根据登录名查询用户
     */
    public static User getUserByUserName(String loginName){
        for (User user : ALL_USERS) {
            // 判断这个用户的登录名是否是我们想要的
            if (user.getLoginName().equals(loginName)){
                return user;
            }
        }
        return null;
    }
}
