package java_knowledge.设计模式.创建式.抽象工厂.review2;

public abstract class AbstractFactory {
    public abstract Shape getShape(String shape);

    public abstract Color getColor(String color);
}
