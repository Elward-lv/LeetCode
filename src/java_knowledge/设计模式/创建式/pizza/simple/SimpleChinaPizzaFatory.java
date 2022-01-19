package java_knowledge.设计模式.创建式.pizza.simple;

import java_knowledge.设计模式.创建式.pizza.ingredient.factory.PizzaIngredientFactory;
import java_knowledge.设计模式.创建式.pizza.pizza.NewYorkHotPizza;
import java_knowledge.设计模式.创建式.pizza.pizza.NewYorkSweetPizza;
import java_knowledge.设计模式.创建式.pizza.pizza.Pizza;

/**
 * 简单工厂方法只是对不同对象创建代码进行封装
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public class SimpleChinaPizzaFatory {

    /**
     * 封装纽约披萨的简单工厂
     * @param pizzaName
     * todo 简单工厂，并不是一种设计模式而是一种创建对象的方法
     * @return
     */
    public Pizza createPizza(String pizzaName,  PizzaIngredientFactory ingredientFactory) {
        Pizza pizza = null;
        if(pizzaName.equals("NewYorkHotPizza")){
            pizza = new NewYorkHotPizza(ingredientFactory);
        }else if(pizzaName.equals("NewYorkSweetPizza")){
            pizza = new NewYorkSweetPizza(ingredientFactory);
        }
        return pizza;
    }
}
