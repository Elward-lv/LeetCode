package java_knowledge.JVM.字符串;

import java.util.StringTokenizer;

/**
 * StringTokenizer相比String.split()
 * 前者不使用正则表达式，后者使用正则表达式
 */
public class StringTokenizerTest {
    public static void main(String[] args) {
        StringTokenizer st = new StringTokenizer("D A\tB\nC\r\fE\t\r\n\fT");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
