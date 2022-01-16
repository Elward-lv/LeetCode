package java_knowledge.设计模式.行为式.策略模式;

public class Duck {
    private QuackBehavior quackBehavior;

    private FlyBehavior flyBehavior;

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void performQuack() {
        if (quackBehavior != null) {
            quackBehavior.quack();
        }
    }

    public void performFly() {
        if (flyBehavior != null) {
            flyBehavior.fly();
        }
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
