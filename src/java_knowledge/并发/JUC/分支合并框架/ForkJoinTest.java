package java_knowledge.并发.JUC.分支合并框架;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 把1-100的累加使用分支合并框架实现
 * ForkJoinPool的使用
 * 结果如下：0-1000000000L
 *      =====>res:500000000500000000
 * ForkJoin花费 时间:638
 * =====>res:500000000500000000
 * noForkJoin花费 时间:749
 */
class MyTask extends RecursiveTask<Long> {
    private final long ADJUST_VALUE = 100000000L;//这个区间的划分也会影响运算的时间效率
    private long begin;
    private long end;
    private  long res;

    public MyTask(long begin, long end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if((end - begin)<=ADJUST_VALUE){
            for (long i = begin; i<= end ; i++){
                res += i;
            }
        }else {
            long mid = (begin + end)/2;
            MyTask myTask1 = new MyTask(begin,mid);
            MyTask myTask2 = new MyTask(mid+1,end);
            myTask1.fork();
            myTask2.fork();

            res = myTask1.join() + myTask2.join();
        }
        return res;
    }
}

public class ForkJoinTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyTask myTask = new MyTask(0L,1000000000L);
        ForkJoinPool fjp = new ForkJoinPool();
        long last = System.currentTimeMillis();
        ForkJoinTask<Long> submit = fjp.submit(myTask);
        System.out.println("=====>res:"+submit.get());
        long now = System.currentTimeMillis();
        System.out.println("ForkJoin花费 时间:"+(now - last));

        noForkJoin(0L, 1000000000L);
    }

    public static void noForkJoin(long start ,long end){
            long last2 = System.currentTimeMillis();
            long res = 0;
            for (long i = start ;i<= end ;i++){
                res += i;
            }
            System.out.println("=====>res:"+res);
            long now2 = System.currentTimeMillis();
            System.out.println("noForkJoin花费 时间:"+(now2 - last2));
    }
}
