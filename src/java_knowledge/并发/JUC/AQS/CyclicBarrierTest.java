package java_knowledge.并发.JUC.AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CyclicBarrier循环栅栏的使用
 * 多个线程互相等待，直到所有线程共同达到一个水平
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        int threadSize = 10;

        CyclicBarrier clb = new CyclicBarrier(threadSize,()->{
            //线程都达到目的的时候需要做的事情
            System.out.println("龙珠集结完成!");
        });
        ExecutorService service = Executors.newFixedThreadPool(threadSize);

        for (int i = 0; i < threadSize; i++) {
            service.submit(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"-->收集一个龙珠");
                    clb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        service.shutdown();
        //System.out.println("main finished");
    }
}
