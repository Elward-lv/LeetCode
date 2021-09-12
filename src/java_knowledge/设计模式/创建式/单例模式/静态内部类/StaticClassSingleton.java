package java_knowledge.设计模式.创建式.单例模式.静态内部类;

/**
 * 使用静态内部类的方法实现单例模式
 */
public class StaticClassSingleton {
    private StaticClassSingleton(){}

    private static class SingletonHolder{
        private static final StaticClassSingleton
        instance = new StaticClassSingleton();
    }

    public static StaticClassSingleton getInstance(){
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        MyThread t4 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
