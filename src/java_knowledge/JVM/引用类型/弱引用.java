package java_knowledge.JVM.引用类型;

import java.lang.ref.WeakReference;

/**
 * 被弱引用关联的对象一定会被回收，也就是说它只能存活到下一次垃圾回收发生之前。
 *
 * 使用 WeakReference 类来创建弱引用。
 */
public class 弱引用 {
    public static void main(String[] args) {
        Object obj = new Object();
        WeakReference<Object> o = new WeakReference<>(obj);
        obj = null;
    }
}
