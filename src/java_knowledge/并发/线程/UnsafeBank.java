package java_knowledge.并发.线程;

/**
 * 模拟取钱的线程安全问题
 * 自己和女朋友一起取钱，而总取款超过账户余额
 * <p>
 * sleep放大程序的不安全性
 */
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(100);
        DrawingMoney lvyanwei = new DrawingMoney(50, "lvyanwei", account);
        DrawingMoney myWife = new DrawingMoney(100, "myWife", account);//剩余money:-50

        myWife.start();
        lvyanwei.start();
    }
}

class Account {
    int totalMoney;

    public Account(int totalMoney) {
        this.totalMoney = totalMoney;
    }
}

class DrawingMoney extends Thread {
    Account account;
    int leftMoney;
    int drawingMoney;


    public DrawingMoney(int drawingMoney, String name, Account account) {
        super(name);
        this.drawingMoney = drawingMoney;
        this.account = account;
    }

    @Override
    public void run() {
        drawing();
    }

    public void drawing() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (account) {
            if (account.totalMoney - drawingMoney < 0) {
                System.out.println("=========>" + this.getName() + "取钱" +"，钱不够了！");
                return;
            }
        }


        leftMoney += drawingMoney;
        account.totalMoney -= drawingMoney;
        System.out.println("=========>" + this.getName() + "取钱" + drawingMoney + ",剩余money:" + account.totalMoney);


    }
}