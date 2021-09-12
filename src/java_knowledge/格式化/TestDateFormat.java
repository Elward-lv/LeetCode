package java_knowledge.格式化;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * DateFormat的使用介绍
 * 2019-12-24 4-59-100
 * 2019-12-24:date
 * 4-59-100:time
 */
public class TestDateFormat {

    @Test
    public void test1(){
        Locale china = Locale.CHINA;
        Locale france = Locale.FRANCE;
        Locale us = Locale.US;

        //getDateInstance
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL , china);
        String format = dateFormat.format(date);
        System.out.println(format);//2021年1月4日星期一
        //getTimeInstance
        DateFormat dateFormat1 = DateFormat.getTimeInstance(DateFormat.FULL, china);
        String format2 = dateFormat1.format(date);
        System.out.println(format2);//中国标准时间 下午8:00:07
        //getDateTimeInstance
        DateFormat dateFormat2 = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, china);
        String format3 = dateFormat2.format(date);
        System.out.println(format3);//2021年1月4日星期一 中国标准时间 下午8:00:07
    }

    @Test
    public void test2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date());
        System.out.println(format);
    }
}
