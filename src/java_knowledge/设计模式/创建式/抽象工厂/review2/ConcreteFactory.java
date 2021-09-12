package java_knowledge.设计模式.创建式.抽象工厂.review2;

public class ConcreteFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shape) {
        if("square".equalsIgnoreCase(shape)){
            return new Square();
        }
        return new Circle();
    }

    @Override
    public Color getColor(String color) {
        if("yellow".equalsIgnoreCase(color)) return new Yellow();
        return new Red();
    }
}
