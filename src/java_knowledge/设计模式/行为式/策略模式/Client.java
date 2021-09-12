package java_knowledge.设计模式.行为式.策略模式;

/**
 * 策略模式：可以设置策略，从而根据不同的策略应对不同的情况
 */
public class Client {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.setQuackBehavior(new Quack());
        duck.performQuack();

        duck.setQuackBehavior(new Squeak());
        duck.performQuack();
    }
}
