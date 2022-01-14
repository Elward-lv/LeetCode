package java_knowledge.设计模式.结构式.装饰模式;

/**
 * 饮料接口
 */
public abstract class Beverage {
    protected String disp = "Unknown beverage !";

    abstract double cost();

    public String getDisp(){
        return disp;
    }
}
