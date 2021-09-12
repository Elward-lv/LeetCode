package java_knowledge.并发.JUC;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程情况下，int类型值的累加出现线程不安全问题演示
 */
public class CntCountNotSafe {
    private int cnt = 0;

    public void add(){
        cnt++;
    }

    public Integer get(){
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        int threadSize = 1000;
        CntCountNotSafe c1 = new CntCountNotSafe();
        //保证主线程在所有子线程完成之后完成
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            service.execute(()->{
                c1.add();
                countDownLatch.countDown();
            });
        }
        //用来控制主线程等待
        countDownLatch.await();
        service.shutdown();
        System.out.println(c1.get());//1000 or 998 or 993 ....
    }
}
