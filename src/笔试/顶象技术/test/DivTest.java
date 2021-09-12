package 笔试.顶象技术.test;

import org.junit.Test;
import 笔试.顶象技术.com.dingxianginc.Calculator;

/**
 * 我认为测试的都是Number的子类，所以针对这些进行测试，但是对于边界用例不太好找
 *  序号   Div除法的测试用例     预测       实际     功能
 *  1.      2 ，5            0.4        0.4       整数
 *  2.      -1，5            -0.2       -0.2      负数
 *  3.      5.6, 4.524      1.23       1.23    浮点数
 *  4.      odwo,dsd        异常        测试通过    错误用例
 *  5.      10, 0           异常        测试通过    错误用例
 */
public class DivTest {
    private static  Calculator calc = new Calculator();
    @Test
    public void testNormal01(){
        System.out.println(calc.div(2, 5));
    }

    @Test
    public void testNormal02(){
        System.out.println(calc.div(-1, 5));
    }

    @Test(expected = NumberFormatException.class)
    public void testBad03(){
        System.out.println(calc.div("odwo", "dsd"));
    }

    @Test(expected = RuntimeException.class)
    public void testNormal04(){
        System.out.println(calc.div(10, 0));
    }
}
