package java_knowledge.设计模式.创建式.抽象工厂;
//用于创建2的产品
public class ConcreteFactory2 extends AbstractFactory{

    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
