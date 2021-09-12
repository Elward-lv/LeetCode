package java_knowledge.设计模式.创建式.抽象工厂.review2;

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory();
        factory.getShape("square").draw();
        factory.getColor("reD").fill();
    }
}
