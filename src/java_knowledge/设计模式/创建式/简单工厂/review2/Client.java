package java_knowledge.设计模式.创建式.简单工厂.review2;

public class Client {
    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        simpleFactory.createProduct(1).hello();
    }
}
