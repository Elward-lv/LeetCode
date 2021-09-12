package java_knowledge.设计模式.创建式.抽象工厂;
//用于创建1的产品  相当于两条产品线
public class ConreteFactory1 extends AbstractFactory {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
