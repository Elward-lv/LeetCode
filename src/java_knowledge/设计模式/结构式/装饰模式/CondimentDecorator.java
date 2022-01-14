package java_knowledge.设计模式.结构式.装饰模式;

public abstract class CondimentDecorator extends Beverage{
    /**
     * 调料需要包装的饮料
     */
    protected Beverage beverage;

    /**
     * 调料的描述(相当于饮料的描述+调料)
     * @return
     */
    public abstract String getDisp();
}
