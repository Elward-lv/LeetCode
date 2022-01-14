package java_knowledge.设计模式.结构式.装饰模式.jdk;

import java_knowledge.设计模式.结构式.装饰模式.Beverage;
import java_knowledge.设计模式.结构式.装饰模式.CondimentDecorator;

/**
 * 测试protect的范围--不同包子类也可以访问
 * @Author: lvyanwei
 * @Date: 2022-01-14
 */
public class ProtectBeverage extends CondimentDecorator {
    protected ProtectBeverage(Beverage beverage) {
        super(beverage);
    }

    @Override
    public double cost() {
        return 0;
    }
}
