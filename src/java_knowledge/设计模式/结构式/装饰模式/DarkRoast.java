package java_knowledge.设计模式.结构式.装饰模式;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        this.disp = "dark roast ";
    }

    @Override
    public double cost() {
        return 1;
    }
}
