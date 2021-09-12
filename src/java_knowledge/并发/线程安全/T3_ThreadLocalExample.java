package java_knowledge.并发.线程安全;

/**
 * 演示把共享变量通过一个线程本地存储来保证线程安全
 */
public class T3_ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(20);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadLocal.get());
                threadLocal.remove();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set(100);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadLocal.get());
                threadLocal.remove();
            }
        });

        t1.start();
        t2.start();


    }
}
