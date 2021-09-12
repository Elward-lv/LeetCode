package java_knowledge.并发.线程.死锁;

/**
 * 模拟多个线程共享资源的死锁问题
 * 女朋友化妆的问题,只有一个mirro和pen，两个女朋友分别有一个资源
 */
public class LockTest {
    public static void main(String[] args) {
        GirlFriend girlFriend = new GirlFriend(0,"小红");
        GirlFriend girlFriend2 = new GirlFriend(1,"小城");
        girlFriend.start();
        girlFriend2.start();//出现死锁问题
    }
}

class Mirro{

}
class Pen{

}

class GirlFriend extends Thread{
    static Mirro mirro = new Mirro();//0
    static Pen pen = new Pen();//1

    private int choice;
    GirlFriend(int choice,String name){
        super(name);
        this.choice = choice;
    }

    @Override
    public void run() {
        draw();
    }

    public void draw(){
        //互相持有对象的锁，但是又需要拿到对象的资源
        if(choice == 0){
            synchronized (mirro){
                System.out.println(this.getName()+"获得mirro!");
                synchronized (pen){
                    System.out.println(this.getName()+"获得pen!");
                }
            }
        }{
            synchronized (pen){
                System.out.println(this.getName()+"获得pen!");
                synchronized (mirro){
                    System.out.println(this.getName()+"获得mirro!");
                }
            }
        }
    }
}