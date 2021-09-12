package java_knowledge.并发.线程池;

import java.util.concurrent.*;

/**
 * AbortPolicy：线程数大于8时，出现异常 RejectedExecutionException
 * CallerRunsPolicy: 部分出现main===>execute! 返回main执行任务
 * 其他：执行max个任务，但是会拒绝某些任务
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(
                2,
                5,
                3L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        try {
            for (int i = 0; i < 20; i++) {
                service.submit(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println(Thread.currentThread().getName() + "===>execute!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }

    }
}
