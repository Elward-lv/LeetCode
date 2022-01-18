package java_knowledge.设计模式.创建式.简单工厂.review3.simple;

import java_knowledge.设计模式.创建式.简单工厂.review3.pizza.NewYorkHotPizza;
import java_knowledge.设计模式.创建式.简单工厂.review3.pizza.NewYorkSweetPizza;
import java_knowledge.设计模式.创建式.简单工厂.review3.pizza.Pizza;

/**
 * NewYork披萨简单工厂--用来封装纽约披萨的种类
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public class SimpleNewYorkPizzaFactory {
    /**
     * 封装纽约披萨的简单工厂
     * @param pizzaName
     * @return
     */
    public Pizza createPizza(String pizzaName) {
        Pizza pizza = null;
        if(pizzaName.equals("NewYorkHotPizza")){
            pizza = new NewYorkHotPizza();
        }else if(pizzaName.equals("NewYorkSweetPizza")){
            pizza = new NewYorkSweetPizza();
        }
        return pizza;
    }
}
