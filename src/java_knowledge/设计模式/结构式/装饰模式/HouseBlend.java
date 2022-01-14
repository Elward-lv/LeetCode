package java_knowledge.设计模式.结构式.装饰模式;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.disp = "House Blend";
    }

    @Override
    public double cost() {
        return 1;
    }
}
