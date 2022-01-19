package java_knowledge.设计模式.创建式.pizza;

import java_knowledge.设计模式.创建式.pizza.ingredient.factory.PizzaIngredientFactory;
import java_knowledge.设计模式.创建式.pizza.pizza.Pizza;
import java_knowledge.设计模式.创建式.pizza.simple.SimpleNewYorkPizzaFactory;

/**
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public class NewYorkPizzaStore extends PizzaStore {

    private SimpleNewYorkPizzaFactory factory ;

    /**
     * 构造方法注入简单工厂和抽象工厂
     * @param factory
     */
    public NewYorkPizzaStore(SimpleNewYorkPizzaFactory factory, PizzaIngredientFactory ingredientFactory) {
        this.factory = factory;
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    Pizza createPizza(String pizzaName) {
        return factory.createPizza(pizzaName, ingredientFactory);
    }
}
