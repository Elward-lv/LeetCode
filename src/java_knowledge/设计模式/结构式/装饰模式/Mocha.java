package java_knowledge.设计模式.结构式.装饰模式;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 1 + beverage.cost();
    }

    @Override
    public String getDisp() {
        return this.beverage.getDisp() + ", mocha ";
    }
}
