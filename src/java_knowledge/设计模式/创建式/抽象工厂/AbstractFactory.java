package java_knowledge.设计模式.创建式.抽象工厂;

/**
 * 抽象工厂模式创建的是对象家族，也就是很多对象而不是一个对象，并且这些对象是相关的，
 * \也就是说必须一起创建出来。而工厂方法模式只是用于创建一个对象，这和抽象工厂模式有很大不同。
 * 抽象工厂模式用到了工厂方法模式来创建单一对象
 */
public abstract class AbstractFactory {
    public abstract AbstractProductA createProductA();

    public abstract AbstractProductB createProductB();
}
