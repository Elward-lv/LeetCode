package java_knowledge.设计模式.结构式.享元模式;

public class Client {
    public static void main(String[] args) {
        FlyWeightFactory factory = new FlyWeightFactory();
        FlyWeight x = factory.getFlyweight("aa");
        FlyWeight y = factory.getFlyweight("aa");

        x.doOperation("x");
        x.doOperation("y");
    }
}
