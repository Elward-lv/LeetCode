package java_knowledge.并发.threadlocal;

import java_knowledge.Stream.User;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @Author: lvyanwei
 * @Date: 2022-03-13
 */
public class ThreadLocalTest {

    private User sharingUser = new User(10, "lvyanwei", 1);

    /**
     * 测试两个local引用同一个对象（类变量）的时候，修改会发生什么？同时会影响两个线程的变量
     * 对于局部变量可以互不影响，此时是副本
     * 因为ThreadLocal的使用场景就不是为了线程同步，而是为了同一个线程内共享数据
     */
    public void testTwoLocal(){
        ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(()->{
            lock.lock();
            ThreadLocal<User> threadLocal = new ThreadLocal<>();
            threadLocal.set(sharingUser);
            System.out.println(Thread.currentThread().getName() + "- threadLocal: "+threadLocal+ "-user:"+threadLocal.get());
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + "- threadLocal: "+threadLocal+ "-user:"+threadLocal.get());
        });

        Thread thread2 = new Thread(()->{
            try {
                //让1完成引用并自我阻塞之后开始进行2的user修改
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();
            ThreadLocal<User> threadLocal = new ThreadLocal<>();
            threadLocal.set(sharingUser);
            System.out.println(Thread.currentThread().getName() + "- threadLocal: "+threadLocal+ "-user:"+threadLocal.get());
            sharingUser.setName("change");
            sharingUser.setAge(20);
            System.out.println(Thread.currentThread().getName() + "- threadLocal: "+threadLocal+ "-user:"+threadLocal.get());
            lock.unlock();
        });

        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) {
        ThreadLocalTest localTest = new ThreadLocalTest();
        localTest.testTwoLocal();
    }
}
