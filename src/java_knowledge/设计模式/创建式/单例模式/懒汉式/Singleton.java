package java_knowledge.设计模式.创建式.单例模式.懒汉式;

/**
 *
 * 饿汉式单例模式
 * 线程不安全
 * 好处：延迟实例化带来的节约资源的好处
 */
public class Singleton {
    private static Singleton singleton;

    private Singleton(){
        System.out.println("singleton init once....");
    }

    public static Singleton getSingleton(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }

    //测试多线程的影响
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        MyThread myThread3 = new MyThread();
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
