package java_knowledge.并发.线程;

public class ThreadSleepInterruptTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println("over!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("中断了");
                }
            }
        });
        t1.start();
        System.out.println(t1.getState());
        t1.interrupt();
    }
}
