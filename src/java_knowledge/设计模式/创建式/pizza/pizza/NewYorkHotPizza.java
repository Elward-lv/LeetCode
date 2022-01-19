package java_knowledge.设计模式.创建式.pizza.pizza;

import java_knowledge.设计模式.创建式.pizza.ingredient.factory.PizzaIngredientFactory;

/**
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public class NewYorkHotPizza extends Pizza {

    public NewYorkHotPizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
        this.name = "NewYorkHotPizza";
    }

    @Override
    public void prepared() {
        this.dough = this.ingredientFactory.createDough();
        this.sauce = this.ingredientFactory.createSauce();
        System.out.println(name + " is prepared ..");
    }

}
