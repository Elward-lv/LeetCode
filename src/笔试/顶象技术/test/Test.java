package 笔试.顶象技术.test;

import 笔试.顶象技术.com.dingxianginc.Calculator;

public class Test {
    public static void main(String[] args) {
        Integer i = 10;
        Float j = 12.0f;
        Float v = i - j;
        Double d = new Double(v.toString());
        System.out.println(i.toString()+","+j.toString()+","+v.toString()+","+d.toString());
        System.out.println(i instanceof Number);

        System.out.println(i.doubleValue());

        //测试Calculator
        Calculator calculator = new Calculator();
        System.out.println(calculator.div(10.2145, 20.2458)+","+(10.2145/20.2458));

        System.out.println(calculator.max(new String[]{"20", "56", "30"}));


    }
}
