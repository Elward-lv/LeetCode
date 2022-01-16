package java_knowledge.设计模式.行为式.策略模式;

/**
 * @Author: lvyanwei
 * @Date: 2022-01-16
 */
public class FlyWithRocket implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println(" i am fly with Rocket!");
    }
}
