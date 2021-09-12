package java_knowledge.设计模式.行为式.策略模式;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("squeak!");
    }
}
