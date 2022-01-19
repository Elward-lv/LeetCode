package java_knowledge.设计模式.创建式.pizza;

import java_knowledge.设计模式.创建式.pizza.ingredient.factory.PizzaIngredientFactory;
import java_knowledge.设计模式.创建式.pizza.pizza.Pizza;
import java_knowledge.设计模式.创建式.pizza.simple.SimpleChinaPizzaFatory;

/**
 * 中国披萨店
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public class ChinaPizzaStore extends PizzaStore {

    private SimpleChinaPizzaFatory factory;

    public ChinaPizzaStore(SimpleChinaPizzaFatory factory, PizzaIngredientFactory ingredientFactory) {
        this.factory = factory;
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    Pizza createPizza(String pizzaName) {
        return factory.createPizza(pizzaName, ingredientFactory);
    }
}
