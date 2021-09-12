package java_knowledge.设计模式.创建式.单例模式.饿汉式;

/**
 * 单例模式--饿汉式
 * 缺点：不会延迟实例化
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    public static Singleton getSingleton(){
        return singleton;
    }

    //测试多线程的影响
    public static void main(String[] args) {
        Singleton.MyThread myThread1 = new MyThread();
        Singleton.MyThread myThread2 = new MyThread();
        Singleton.MyThread myThread3 = new MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();

//        Singleton singleton = Singleton.getSingleton();
//        System.out.println("主线程，实例名："+singleton);
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            Singleton singleton = Singleton.getSingleton();
            System.out.println("线程名:"+this.getName()+",实例名:"+singleton);
        }
    }
}
