package java_knowledge.并发.线程.生产者消费者问题;

/**
 * 模拟生产者和消费者的问题
 *      一个消费一个生产
 * 利用缓冲区SynContainer解决生产者消费者问题--管程法
 */
public class PCTest {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        new Produce(synContainer).start();
        new Consume(synContainer).start();
    }
}

class SynContainer{
    int nums = 0;
    Chicken[] chickens = new Chicken[10];

    //生产者放入鸡
    public synchronized void push(Chicken chicken) throws InterruptedException {
        if(nums == chickens.length){
            //通知消费者消费
            this.wait();
        }
        chickens[nums]=chicken;
        nums ++;
        this.notify();
    }

    public synchronized Chicken pop() throws InterruptedException {
        if(nums == 0){
            //通知生产者生产
            this.wait();
        }
        //消费chicken
        nums--;
        this.notify();
        return chickens[nums];
    }
}

class Chicken{
    int id;
    Chicken(int id){
        this.id = id;
    }
}

class Produce extends Thread{
    private SynContainer synContainer;
    Produce(SynContainer synContainer){
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                synContainer.push(new Chicken(i));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("生产了"+i+"只鸡");
        }
    }
}

class Consume extends Thread{
    private SynContainer synContainer;
    Consume(SynContainer synContainer){
        this.synContainer = synContainer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Chicken chicken = null;
            try {
                chicken = synContainer.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("消费了===>"+chicken.id +"只鸡");
        }
    }
}