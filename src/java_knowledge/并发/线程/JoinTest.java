package java_knowledge.并发.线程;

public class JoinTest implements Runnable {
    @Override
    public void run() {
        for (int i = 100; i > 0; i--) {
            System.out.println(Thread.currentThread().getName()+",i="+i);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new JoinTest());
        thread.start();
        for (int i = 1000; i > 0; i--) {
            System.out.println("主线程：i="+i);
            if(i==500){
                thread.join();
            }
        }
    }
}
