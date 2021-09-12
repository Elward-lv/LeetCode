package java_knowledge.并发.JUC.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ShareResource {
    private int num =1;//1A  2B  3C
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5(int loopNum){
        try {
            lock.lock();
            while (num != 1){
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"-> loopNum:"+loopNum);
            }
            num = 2;
            c2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int loopNum){
        try {
            lock.lock();
            while (num != 2){
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"-> loopNum:"+loopNum);
            }
            num = 3;
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print20(int loopNum){
        try {
            lock.lock();
            while (num != 3){
                c3.await();
            }
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName()+"-> loopNum:"+loopNum);
            }
            num = 1;
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
