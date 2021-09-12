package java_knowledge.并发.JUC.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    /**
     * 10个线程争抢5个资源
     * @param args
     */
    public static void main(String[] args) {
        int threadSize = 10;
        Semaphore semaphore = new Semaphore(threadSize/2,true);
        ExecutorService service = Executors.newFixedThreadPool(threadSize);

        for (int i = 0; i < threadSize; i++) {
            service.submit(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"，获取信号量");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"，释放信号量");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }

        service.shutdown();
    }
}
