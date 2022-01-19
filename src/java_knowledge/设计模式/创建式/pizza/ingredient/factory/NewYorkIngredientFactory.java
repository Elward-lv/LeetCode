package java_knowledge.设计模式.创建式.pizza.ingredient.factory;

import java_knowledge.设计模式.创建式.pizza.ingredient.*;

/**
 * 纽约的原料工厂
 * @Author: lvyanwei
 * @Date: 2022-01-19
 */
public class NewYorkIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCristDough();
    }

    @Override
    public Sauce createSauce() {
        return new BlackSauce();
    }

    @Override
    public Cheese createCheese() {
        return new RedHotCheese();
    }
}
