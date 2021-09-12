package CS_Note.算法.排序;

import CS_Note.算法.排序.希尔排序.Shell;

public class TimeWatch {
    private static Long start;

    public static void start(){
        start = System.currentTimeMillis();
    }

    public static void getTime(){
        System.out.println( System.currentTimeMillis()-start);
    }
}
