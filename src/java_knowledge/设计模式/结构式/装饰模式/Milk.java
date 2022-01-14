package java_knowledge.设计模式.结构式.装饰模式;

public class Milk extends CondimentDecorator {
    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + 1;
    }

    /**
     * 调料不仅仅包括饮料的描述还包括调料的描述
     * @return
     */
    @Override
    public String getDisp() {
        return this.beverage.getDisp() + ", milk";
    }
}
