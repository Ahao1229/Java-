package com.study.logback.d2_simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest3 {
    public static void main(String[] args) throws ParseException {
        // 1、开始 和 结束 时间
        String startTime = "2022-11-11 00:00:00";
        String endTime = "2022-11-11 00:10:00";

        // 2、小贾  小渠
        String xiaojia = "2022-11-11 00:03:47";
        String xiaoqu = "2022-11-11 00:10:11";

        // 3、解析他们的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date st = sdf.parse(startTime);
        Date et = sdf.parse(endTime);
        Date jt = sdf.parse(xiaojia);
        Date qt = sdf.parse(xiaoqu);

        if (jt.after(st) && jt.before(et)){
            System.out.println("小贾秒杀成了！！！");
        }
        else {
            System.out.println("小贾你也不行啊！！！");
        }if (qt.after(st) && qt.before(et)){
            System.out.println("小渠秒杀成了！！！");
        }
        else {
            System.out.println("小渠你也不行啊！！！");
        }











    }
}
