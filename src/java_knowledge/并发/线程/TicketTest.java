package java_knowledge.并发.线程;

/**
 * 简单的并发的问题演示
 */
public class TicketTest implements Runnable {
    private int ticketNums = 1000;

    @Override
    public void run() {
        while (true){
            if(ticketNums-- <= 0){
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+",获得了票:"+ticketNums);
        }
    }

    public static void main(String[] args) {
        TicketTest t = new TicketTest();

        new Thread(t,"老师").start();
        new Thread(t,"学生").start();
        new Thread(t,"黄牛党").start();
    }
}
