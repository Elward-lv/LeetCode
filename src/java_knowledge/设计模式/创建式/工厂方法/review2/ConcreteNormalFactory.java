package java_knowledge.设计模式.创建式.工厂方法.review2;

import java_knowledge.设计模式.创建式.NormalProuct;
import java_knowledge.设计模式.创建式.Product;

public class ConcreteNormalFactory extends Factory {
    @Override
    public Product factoryMethod() {
        return new NormalProuct();
    }
}
