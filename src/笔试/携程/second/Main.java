package 笔试.携程.second;

import java.util.Scanner;

/**
 * 给定一个表达式，求其计算结果。
 * <p>
 * 表达式的结构是这样的形式：(operator operand operand …)
 * <p>
 * 1、左右括号分别标志了表达式的开始和结束。
 * 2、operator是操作符，表示了计算规则，取值有三种:+-*，分别是加法、减法、乘法。
 * 3、operand是操作数，它既可以是一个整数，也可以是另一个表达式。操作数至少是两个。
 * 4、括号两边有0个或者多个空格。operator、operand之间有1个或者多个空格。
 * <p>
 * 计算规则如下：
 * 1、 如果operand是一个表达式，要先计算其值，再用该值参与运算。
 * 2、 如果operator是加法或者乘法，把所有operand相加或者相乘。
 * 3、 如果operator是减法，第一个operand是被减数，其他均为减数。
 * 下面几个例子演示了求值过程和结果：
 * <p>
 * (+ 3 4) => 7
 * <p>
 * (- 9 4 5) =>0
 * <p>
 * (- (* 4 5) 4 5) => (-20 4 5) => 11
 * <p>
 * (*(+2 3) (-100 (+ 20 10))) => (* 5 (-100 30)) => (* 5 (-100 30)) => (* 5 70)=> 350
 * <p>
 * in:
 * (+ 3 4)
 * (- 9 4 5)
 * (- (* 4 5) 4 5)
 * (*(+2 3) (-100 (+ 20 10)))
 * <p>
 * out:
 * 7
 * 0
 * 11
 * 350
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*while (sc.hasNext()){
            String text = sc.nextLine();
            System.out.println(analyseText(text));
        }*/
        System.out.println(analyseText("(*(+2 3) (-100 (+ 20 10)))"));
    }

    private static Integer analyseText(String reg) {
        if (reg == null || reg.length() == 0) return null;

        String regTrimed = reg.trim();
        char[] points = regTrimed.toCharArray();
//        System.out.println(Arrays.asList(points));
        return countResult(points, 0, points.length - 1);
    }

    /**
     * 计算表达式的结果
     * 1.有括号（嵌套括号）
     * 2.没括号
     *
     * @param points
     * @param st
     * @param end
     * @return
     */
    private static int countResult(char[] points, int st, int end) {
        Character runMethod = ' ';//计算公式+-*
        int numCount = 0;//数字个数

        int left = st , right = end , index = st , ret = 0;
        while (index <= end){
            if(points[index] == ' ') index++;
            else if(points[index] == '(') { //递归计算
                right = searcheForEnd(points, left+1);
                //这里出问题，递归没考虑运算符
                int num = countResult(points , left + 1, right - 1);

                if(runMethod.equals('+')) {
                    ret += num;
                }
                else if(runMethod.equals('*')) {
                    if(ret == 0 && numCount == 1) {
                        ret = num;
                    }
                    else ret *= num;
                }
                else {
                    if(ret == 0 && numCount == 1) {
                        ret = num;
                    }else ret -= num;
                }

                index = right + 1;
            }else{
                //计算括号内部的参数
                if(points[index] == '+'){
                    runMethod = '+';
                    index++;
                }else if(points[index] == '-'){
                    runMethod = '-';
                    index++;
                }else if(points[index] == '*'){
                    runMethod = '*';
                    index++;
                }else {
                    int num = 0;
                    numCount++;
                    while (index <= end){
                        num = num *10 + Integer.parseInt(points[index]+"");
                        if(points[index+1] == ' '){
                            break;
                        }
                        index++;
                    }
                    //根据runMethod把结果加如ret之中
                    if(runMethod.equals('+')) {
                        ret += num;
                    }
                    else if(runMethod.equals('*')) {
                        if(ret == 0 && numCount == 1) {
                            ret = num;
                        }
                        else ret *= num;
                    }
                    else {
                        if(ret == 0 && numCount == 1) {
                            ret = num;
                        }else ret -= num;
                    }
                    index++;
                }
            }
        }
        return ret;
    }

    /**
     * 寻找（匹配的）的位置
     *
     * @param points
     * @param st
     * @return
     */
    private static int searcheForEnd(char[] points, int st) {
        int count = 0;
        for (; st < points.length; st++) {
            if (points[st] == '(') count++;
            else if (points[st] == ')' && count == 0) return st;
            else if (points[st] == ')') count--;
        }
        return -1;
    }
}
