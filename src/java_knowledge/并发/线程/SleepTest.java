package java_knowledge.并发.线程;

/**
 * sleep不会让出对象锁！
 * 线程休眠
 */
public class SleepTest implements Runnable{
    boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println(Thread.currentThread().getName()+",i="+i++);
        }
        System.out.println(Thread.currentThread().getName()+"停止");
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        SleepTest s = new SleepTest();
        new Thread(s,"循环线程").start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程:i="+i);
            if(i > 500){
                s.setFlag(false);
            }
        }
    }
}
