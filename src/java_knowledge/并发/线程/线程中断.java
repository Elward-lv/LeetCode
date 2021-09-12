package java_knowledge.并发.线程;

/**
 * 通过线程的中断方法，提前让线程执行完成
 */
public class 线程中断 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("hello in main!");
        t1.interrupt();
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            //super.run();
            System.out.println("enter thread...");
            while (!interrupted()){
                //死循环
            }
            System.out.println("线程被中断,执行结束!");
        }
    }
}
