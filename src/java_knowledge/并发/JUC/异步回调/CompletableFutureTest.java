package java_knowledge.并发.JUC.异步回调;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //同步任务
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "==>runAsync");
        });
        System.out.println(runAsync.get());
        //异步任务
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync");
            int a = 10/0;
            return 1024;
        });

        future2.whenComplete((t, u) -> {//获取返回值和异常
            System.out.println("t==>"+t);//1024--返回值
            System.out.println("u==>"+u);//null--报错信息
        }).exceptionally(//抓报错
                (t) -> {
                    System.out.println(t.getMessage());
                    return 444;
                }
        );
    }
}
