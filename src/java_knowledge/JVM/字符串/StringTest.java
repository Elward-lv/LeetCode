package java_knowledge.JVM.字符串;

import java.util.Arrays;

/**
 * 验证string的+底层使用stringBuilder实现
 * m1.查看编译之后内容
 * m2.使用null来累加，查看是否和StringBuilder相通,当s为null时，stringBuilder当作字符串:'null'
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = null;
        String s2 = "world";
        System.out.println(s1+s2);//nullworld
        System.out.println(Arrays.toString(s2.getBytes()));//[119, 111, 114, 108, 100]

        String s3 = "你好，hello";
        //s3.code();String的default方法，索引不能在
        //和UTF16编码表有关，这里把空位去除了，下边输出
        System.out.println(Arrays.toString(s3.getBytes()));//[-28, -67, -96, -27, -91, -67, -17, -68, -116, 104, 101, 108, 108, 111]
    }
}
