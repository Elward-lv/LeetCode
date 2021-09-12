package java_knowledge.设计模式.创建式.抽象工厂;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory2 = new ConcreteFactory2();
        AbstractProductA productA = factory2.createProductA();
        AbstractProductB productB = factory2.createProductB();

        //do something whith productA B
    }
}
