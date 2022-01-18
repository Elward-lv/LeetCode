package java_knowledge.设计模式.创建式.简单工厂.review3;

import java_knowledge.设计模式.创建式.简单工厂.review3.pizza.ChinaHotPizza;
import java_knowledge.设计模式.创建式.简单工厂.review3.pizza.ChinaSweetPizza;
import java_knowledge.设计模式.创建式.简单工厂.review3.pizza.Pizza;
import java_knowledge.设计模式.创建式.简单工厂.review3.simple.SimpleChinaPizzaFatory;

/**
 * 中国披萨店
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public class ChinaPizza extends PizzaStore {

    private SimpleChinaPizzaFatory factory;

    public ChinaPizza(SimpleChinaPizzaFatory factory) {
        this.factory = factory;
    }

    @Override
    Pizza createPizza(String pizzaName) {
        Pizza pizza = null;
        if(pizzaName.equals("ChinaHotPizza")){
            pizza = new ChinaHotPizza();
        }else if(pizza.equals("ChinaSweetPizza")){
            pizza = new ChinaSweetPizza();
        }
        return null;
    }
}
