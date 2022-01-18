package java_knowledge.设计模式.创建式.简单工厂.review3;

import java_knowledge.设计模式.创建式.简单工厂.review3.pizza.Pizza;
import java_knowledge.设计模式.创建式.简单工厂.review3.simple.SimpleNewYorkPizzaFactory;

/**
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public class NewYorkPizzaStore extends PizzaStore {

    private SimpleNewYorkPizzaFactory factory ;

    /**
     * 构造方法注入简单工厂
     * @param factory
     */
    public NewYorkPizzaStore(SimpleNewYorkPizzaFactory factory) {
        this.factory = factory;
    }

    @Override
    Pizza createPizza(String pizzaName) {
        return factory.createPizza(pizzaName);
    }
}
