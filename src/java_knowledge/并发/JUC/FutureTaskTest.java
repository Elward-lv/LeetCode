package java_knowledge.并发.JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class MyTask implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(4);
        System.out.println("callable run.....");
        return 200;
    }
}
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> ft = new FutureTask<>(new MyTask());
        new Thread(ft,"anotherThread").start();

        while (!ft.isDone()){
            System.out.println("wait...");
        }
        System.out.println(ft.get());
        System.out.println("main finished");
    }
}
