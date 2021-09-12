package java_knowledge.并发.JUC;

import java.util.Collections;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CntCountNotSafe中线程不安全问题，通过AtomicInteger解决
 */
public class AtomicIntegerTest {
    private AtomicInteger atomicInteger  = new AtomicInteger();

    public void add(){
        atomicInteger.incrementAndGet();
    }

    public Integer get(){
        return atomicInteger.get();
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest test = new AtomicIntegerTest();
        int threadSize = 1000;
        CountDownLatch latch = new CountDownLatch(threadSize);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            service.execute(()->{
                test.add();
                latch.countDown();
            });
        }
        latch.await();
        service.shutdown();
        System.out.println(test.get());//1000
    }
}
