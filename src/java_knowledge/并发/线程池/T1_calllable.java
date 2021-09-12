package java_knowledge.并发.线程池;

import java.util.concurrent.*;

/**
 * Callable接口的使用
 *      特点：具有返回值--Future<Object>
 */
public class T1_calllable implements Callable<Object> {

    @Override
    public Object call() throws Exception {
        System.out.println("callable test...");
        return "success";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        T1_calllable t1 = new T1_calllable();
        ExecutorService service = Executors.newCachedThreadPool();
        Future<Object> future = service.submit(t1);
        Object o = future.get();
        service.shutdown();
        System.out.println(o);
    }
}
