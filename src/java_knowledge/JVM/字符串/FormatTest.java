package java_knowledge.JVM.字符串;

import java.util.Date;

/**
 * 需求：如果我们需要一串字符串->xxx 来自 上海 ，年龄 20岁 ， 身高 168 cm
 * 这里面的上海是可变的string
 * 20是可变的int
 * 68是可变的int
 * 我们需要怎么构造字符串呢？是每次都new一个string，然后把所有的拼接到一起？但是需要考虑到不同的语言环境,而且万一20需要周围需要有多个空格呢？
 * 能不能创建一个通用的方法来格式化呢，并且可以传入格式化的格式
 * =========解决：可以使用String.format()方法===========
 * 但是需要参照格式化字符串表：如OneNote笔记
 */
public class FormatTest {
    public static void main(String[] args) {
        String str=null;
        str=String.format("Hi,%s", "小超");
        System.out.println(str);
        str=String.format("Hi,%s %s %s", "小超","是个","大帅哥");
        System.out.println(str);
        System.out.printf("字母c的大写是：%c %n", 'C');
        System.out.printf("布尔结果是：%b %n", "小超".equals("帅哥"));
        System.out.printf("100的一半是：%d %n", 100/2);
        System.out.printf("100的16进制数是：%x %n", 100);
        System.out.printf("100的8进制数是：%o %n", 100);
        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
        System.out.printf("上面价格的16进制数是：%a %n", 50*0.85);
        System.out.printf("上面价格的指数表示：%e %n", 50*0.85);
        System.out.printf("上面价格的指数和浮点数结果的长度较短的是：%g %n", 50*0.85);
        System.out.printf("上面的折扣是%d%% %n", 85);
        System.out.printf("字母A的散列码是：%h %n", 'A');

        //======================测试date
        Date date = new Date();
        String da = String.format("%tc",date);// 周日 12月 06 13:00:59 CST 2020
        String da2 = String.format("%tD", date);// 12/06/20
        String da3 = String.format("%tF", date);// 2020-12-06
        System.out.println("1今天的日期是："+da);
        System.out.println("2今天的日期是："+da2);
        System.out.println("3今天的日期是："+da3);
    }
}
