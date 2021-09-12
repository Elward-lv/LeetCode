package java_knowledge.设计模式.行为式.中介者模式;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 中介者
 * 提供一个中介得位置来处理多个对象之间得复杂关系。
 *
 * - All scheduleXXX() methods of [java.util.Timer]
 * - [java.util.concurrent.Executor#execute()]
 * - submit() and invokeXXX() methods of [java.util.concurrent.ExecutorService]
 * - scheduleXXX() methods of [java.util.concurrent.ScheduledExecutorService]
 * - [java.lang.reflect.Method#invoke()]
 */
public class Client {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        CoffeePot coffeePot = new CoffeePot();
        Calender calender = new Calender();
        Sprinkler sprinkler = new Sprinkler();
        ConcreteMediator mediator = new ConcreteMediator(alarm, coffeePot, calender, sprinkler);
        // 闹钟事件到达，调用中介者就可以操作相关对象
        alarm.onEvent(mediator);

    }
}
