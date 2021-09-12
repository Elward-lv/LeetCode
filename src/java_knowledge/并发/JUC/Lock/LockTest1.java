package java_knowledge.并发.JUC.Lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 谁先抢到锁谁先计数，完成之后另外一个才能计数
 */
public class LockTest1 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                lock.lock();
                while (count < 1000){
                    count++;
                    System.out.println("t1:"+count);
                }
                lock.unlock();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                lock.lock();
                while (count < 1000){
                    count++;
                    System.out.println("t2:"+count);
                }
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }
}
