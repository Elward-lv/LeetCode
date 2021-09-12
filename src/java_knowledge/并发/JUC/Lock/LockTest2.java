package java_knowledge.并发.JUC.Lock;

/**
 * 通过使用lock的condition 来达到多个线程控制一个类的改变
 * 顺序是print5->print10->print20的顺序，不会乱
 */
public class LockTest2 {
    public static void main(String[] args) {
        ShareResource sr = new ShareResource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<5;i++) {
                    sr.print5(1);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i< 5;i++) {
                    sr.print10(2);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0;i< 5;i++) {
                    sr.print20(3);
                }
            }
        }).start();
    }
}
