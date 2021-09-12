package java_knowledge.设计模式.创建式.工厂方法.review2;

public class Client {
    public static void main(String[] args) {
        Factory factory = new ConcreteHighFactory();
        factory.doSomething();
    }
}
