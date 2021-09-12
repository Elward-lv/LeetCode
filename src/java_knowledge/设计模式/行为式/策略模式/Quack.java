package java_knowledge.设计模式.行为式.策略模式;

public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("quack!");
    }
}
