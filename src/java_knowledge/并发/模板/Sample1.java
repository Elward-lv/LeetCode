package java_knowledge.并发.模板;

/**
 * 生产者和消费者问题，一个对num+，一个-
 */
class ShareResource{
    private int num = 0;

    public synchronized void incr() throws Exception{
        //判断  需要使用循环判断！
        while (num != 0){
            this.wait();
        }
        //动作
        num++;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName()+",num:"+num);
    }

    public synchronized void decr() throws Exception{
        //判断 不为1进行--操作
        while(num != 1){
            this.wait();
        }
        //动作
        num--;
        this.notifyAll();
        System.out.println(Thread.currentThread().getName()+",num:"+num);
    }
}

public class Sample1 {

    public static void main(String[] args) {
        ShareResource s = new ShareResource();
        new Thread(()->{
            try {
                for (int i = 0;i<10;i++) {
                    s.incr();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"incr").start();

        new Thread(()->{
            try {
                for (int i = 0;i<10;i++) {
                    s.decr();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"decr").start();

        new Thread(()->{
            try {
                for (int i = 0;i<10;i++) {
                    s.incr();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"incr2").start();

        new Thread(()->{
            try {
                for (int i = 0;i<10;i++) {
                    s.decr();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"decr2").start();
    }
}
