package java_knowledge.设计模式.创建式.pizza.ingredient.factory;

import java_knowledge.设计模式.创建式.pizza.ingredient.Cheese;
import java_knowledge.设计模式.创建式.pizza.ingredient.Dough;
import java_knowledge.设计模式.创建式.pizza.ingredient.Sauce;

/**
 * 创建披萨原料的接口
 */
public interface PizzaIngredientFactory {

    Dough createDough();

    Sauce createSauce();

    Cheese createCheese();

    /**
     * 可能还有其他原料....
     */
}
