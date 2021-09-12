package java_knowledge.JVM.常量池;

/**
 * 			需要注意的是：包装类型，对象存储，new出来的对象都是存储在堆中，
 * 			Byte,Short,Integer,Long,Character这5种整型的包装类只是
 * 			在对应值小于等于127时才可使用对象池。超过了就会自动申请空间创建对象
 */
public class 包装数据类型 {
    Integer i1 = 10;
    Integer i2 = 10;
    Integer i3 = 400;
    Integer i4 = 400;

    Byte b1 = 10;
    Byte b2 = 10;

    Character c1 = 'C';
    Character c2 = 'C';
    Character c3 = '.';
    Character c4 = '.';

    public static void main(String[] args) {
        包装数据类型 obj = new 包装数据类型();
        System.out.println((obj.i1==obj.i2)+","+(obj.i3==obj.i4)+","+(obj.b1==obj.b2)+","+(obj.c1==obj.c2)+","+(obj.c3==obj.c4));
        //                  true,                 false,                true,               true,                   true
    }
}
