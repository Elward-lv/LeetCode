package java_knowledge.并发.线程安全;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 栈封闭
 *      多个共同访问同一个局部变量时，不会出现线程安全问题，因为局部变量存储在虚拟机栈中，属于线程私有的。
 */
public class T2_StackClosedExample {
    public void add100(){
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            cnt++;
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        T2_StackClosedExample obj = new T2_StackClosedExample();
        service.execute(()->obj.add100());
        service.execute(()->obj.add100());
        service.shutdown();
    }
}
