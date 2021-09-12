package java_knowledge.内存泄露;

import java.util.Collections;
import java.util.HashSet;
import java.util.Vector;

public class UnusedClass {
    public static void main(String[] args) {
        test2();
    }

    //1.静态集合类引起内存泄漏
    public static void test1(){
        Vector<Object> vector = new Vector<>();
        Object o = new Object();
        vector.add(o);
        o = null;
        System.out.println(vector.get(0));
    }
    //2.当集合里面的对象属性被修改后，再调用remove()方法时不起作用

    /**
     * 原因也很简单。由于我重写了HashCode,导致在删除得时候通过hashCode找不到对应得key，所以删除不了
     * 从新添加得时候，由于我修改了age，而计算hashcode得时候age也是其中得元素之一，所以会导致添加成功
     * 此时上次未修改得wo3就成为了内存泄漏的对象
     */
    public static void test2(){
        HashSet<Object> set = new HashSet<>();
        Person wo = new Person("wo", "111", 20);
        Person wo2 = new Person("wo2", "112", 15);
        Person wo3 = new Person("wo3", "113", 45);
        set.add(wo);
        set.add(wo2);
        set.add(wo3);

        wo3.setAge(50);
        set.remove(wo3);
        set.add(wo3);
        for (Object o : set) {
            System.out.println(o.toString());//4个元素
        }
    }
}
