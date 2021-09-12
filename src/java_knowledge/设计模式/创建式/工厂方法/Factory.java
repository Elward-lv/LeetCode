package java_knowledge.设计模式.创建式.工厂方法;

import java_knowledge.设计模式.创建式.Product;

//定义了一个创建对象的接口，但由子类决定要实例化哪个类。工厂方法把实例化操作推迟到子类。
public abstract class Factory {
    public abstract Product factoryMethod();

    public void doSomething(){
        Product product = factoryMethod();
        //doSomething with the product
        product.hello();
    }

    public static void main(String[] args) {
        /**
         * 根据创建工厂的不同来返回不同的product，利用类的向上转型，即多态
         */
        Factory factory = new ConcreteHighFactory();
        factory.doSomething();
    }
}
