package 笔试.顶象技术.test;

import org.junit.Test;
import 笔试.顶象技术.com.dingxianginc.Calculator;

/**
 * 用于测试Sub减法的测试用例集合(+加法类似)
 *  序号    Sub 的测试用例     预测       实际     功能
 *  1.      2 ，5            -3        -3       整数
 *  2.      -4, -6          2          2        负数
 *  3.      1.25, 2.36      -1.11      -1.1   浮点数
 *  4.      1 , 0           1          1.0       0
 */
public class SubTest {
    private static Calculator calc = new Calculator();
    @Test
    public void testNormal01(){
        System.out.println(calc.sub(2, 5));
    }

    @Test
    public void testNormal02(){
        System.out.println(calc.sub(-4, -6));
    }

    @Test
    public void testNormal03(){
        System.out.println(calc.sub(1.25, 2.36));
    }

    @Test
    public void testNormal04(){
        System.out.println(calc.sub(1, 0));
    }
}
