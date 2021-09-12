package java_knowledge.运算符;

public class 移位运算符 {
    public static void main(String[] args) {
        byte b = 64;
        byte b2 = 64;
        System.out.println(b);//64
        System.out.println((b << 8));//16384
        System.out.println(((b2 & 0xff) << 8));//16384
//================================================
        //当小于127的时候与上0xff不会发生什么变化，但是当大于127时，就会起作用，会把高位置零
        byte b3 = 127;
        byte b4 = 127;
        System.out.println(b3);//64
        System.out.println((b3 << 8));//16384
        System.out.println(((b4 & 0xff) << 8));//16384

        //循环移位不适用于string
        String s = "hello";

    }
}
