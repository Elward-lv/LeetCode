package java_knowledge.设计模式.创建式.pizza.ingredient.factory;

import java_knowledge.设计模式.创建式.pizza.ingredient.*;

/**
 * 中国地区原料工厂
 * @Author: lvyanwei
 * @Date: 2022-01-19
 */
public class ChinaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new SoftChinaDough();
    }

    @Override
    public Sauce createSauce() {
        return new SoftChinaSauce();
    }

    @Override
    public Cheese createCheese() {
        return new SoftChinaCheese();
    }
}
