package java_knowledge.设计模式.创建式.单例模式.双重校验锁;

/**
 * 双重校验锁单例模式的使用
 *      synchronized
 *      volatile
 */
public class 双重校验锁 {
    private volatile static 双重校验锁 singleton;

    private 双重校验锁(){}

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            双重校验锁 singleton = 双重校验锁.getSingleton();
            System.out.println("线程名:"+this.getName()+",实例名:"+singleton);
        }
    }

    private static 双重校验锁 getSingleton() {
        if(singleton == null){
            System.out.println("thread go into first if...");
            synchronized (双重校验锁.class){//判断 uniqueInstance 是否已经被实例化
                if(singleton == null){
                    singleton = new 双重校验锁();
                }
            }
        }
        return singleton;
    }
}
