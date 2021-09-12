package java_knowledge.并发.线程;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TenDown {

    public static void main(String[] args) {
        tenDown(10);
    }

    public static void tenDown(int count){
        for (int i = count; i > 0; i--) {
            System.out.println(i);
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
