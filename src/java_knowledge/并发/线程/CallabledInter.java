package java_knowledge.并发.线程;

import java.util.Random;
import java.util.concurrent.*;

public class CallabledInter implements Callable<Object> {
    @Override
    public Object call() {
        int res = new Random().nextInt();
        System.out.println("hello,"+res);
        return res;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.submit(new CallabledInter());
        service.submit(new CallabledInter());
        service.submit(new CallabledInter());
        Future<Object> res = service.submit(new CallabledInter());
        service.shutdown();

    }
}
