package java_knowledge.设计模式.创建式.工厂方法.review2;

import java_knowledge.设计模式.创建式.Product;

/**
 * 工厂方法通过抽象类中的方法在 子类实现的不同 创建不同的工厂去生产对应的对象
 * 一个方法只是用于创建一个对象
 */
public abstract class Factory {
    public abstract Product factoryMethod();

    public void doSomething(){
        Product product = factoryMethod();
        //do something
        product.hello();
    }
}
