package java_knowledge.JVM.类加载器;

public class Demo01 {
    public static void main(String[] args) {
        Object obj = new Object();
        Demo01 d1 = new Demo01();
        String s = new String("hello");

        System.out.println(obj.getClass().getClassLoader());//null 启动类加载器C++的
        System.out.println(d1.getClass().getClassLoader().getParent().getParent());//null
        System.out.println(d1.getClass().getClassLoader().getParent());//jdk.internal.loader.ClassLoaders$PlatformClassLoader@2133c8f8
        System.out.println(d1.getClass().getClassLoader());//jdk.internal.loader.ClassLoaders$AppClassLoader@27f8302d
        System.out.println(s.getClass().getClassLoader());//null
    }
}
