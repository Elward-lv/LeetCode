package java_knowledge.设计模式.创建式.单例模式.懒汉式;

/**
 * 懒汉式的线程安全形式
 */
public class SafeSingleton {
    private static SafeSingleton singleton;

    private SafeSingleton(){
        System.out.println("safe singleton init once....");
    }

    public synchronized static SafeSingleton getSingleton(){
        if(singleton == null){
            singleton = new SafeSingleton();
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
            SafeSingleton singleton = SafeSingleton.getSingleton();
            System.out.println("线程名:"+this.getName()+",实例名:"+singleton);
        }
    }
}
