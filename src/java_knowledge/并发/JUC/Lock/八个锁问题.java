package java_knowledge.并发.JUC.Lock;

import java.util.concurrent.TimeUnit;

class Phone{
    public synchronized void sendSMS() {
        try {
            TimeUnit.SECONDS.sleep(4);
            System.out.println("====>send SMS!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sendEmail(){
        System.out.println("====>send Email!");
    }
}

public class 八个锁问题 {
    /**
     * 事实证明：线程的启动顺序对线程抢占锁有不小影响
     * @param args
     */

    public static void main(String[] args) {
        Phone p = new Phone();
        new Thread(p::sendEmail).start();
        new Thread(p::sendSMS).start();
        //TimeUnit.SECONDS.sleep(4);

    }
}
