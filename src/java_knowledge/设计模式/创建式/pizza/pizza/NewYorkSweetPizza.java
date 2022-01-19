package java_knowledge.设计模式.创建式.pizza.pizza;

import java_knowledge.设计模式.创建式.pizza.ingredient.factory.PizzaIngredientFactory;

/**
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public class NewYorkSweetPizza extends Pizza {

    public NewYorkSweetPizza(PizzaIngredientFactory ingredientFactory) {
        super(ingredientFactory);
        this.name = "NewYorkSweetPizza";
    }

    @Override
    public void prepared() {
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        System.out.println(name + " is prepared ..");
    }
}
