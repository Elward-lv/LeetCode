package java_knowledge.并发.线程;

/**
 * 用来观察线程的状态
 *
 * 线程也有 优先级，可以设置和获取优先级
 * 优先级有最大和最小值！10> priority>1
 * 先设置再运行，一般优先级高的会执行
 */
public class States implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        States states = new States();
        Thread thread = new Thread(states);
        Thread.State state = thread.getState();

        System.out.println(state);//NEW
        thread.start();
        state = thread.getState();
        System.out.println(state);//RUUNNING
        while(state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);//TIMED_WAITING or TERMINATED
        }

        //停止之后不能再启动
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
