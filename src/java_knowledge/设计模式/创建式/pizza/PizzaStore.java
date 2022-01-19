package java_knowledge.设计模式.创建式.pizza;

import java_knowledge.设计模式.创建式.pizza.ingredient.factory.ChinaIngredientFactory;
import java_knowledge.设计模式.创建式.pizza.ingredient.factory.PizzaIngredientFactory;
import java_knowledge.设计模式.创建式.pizza.pizza.Pizza;
import java_knowledge.设计模式.创建式.pizza.simple.SimpleNewYorkPizzaFactory;

/**
 * 披萨店：因为存在不同地区的披萨店所以抽象出createPizza方法
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public abstract class PizzaStore {

    PizzaIngredientFactory ingredientFactory;

    public static void main(String[] args) {
        PizzaStore pizzaStore = new NewYorkPizzaStore(new SimpleNewYorkPizzaFactory(), new ChinaIngredientFactory());
        Pizza pizza = pizzaStore.orderPizza("NewYorkHotPizza");
        System.out.println(" eat pizza : " + pizza);
    }

    /**
     * 制作披萨标准流程
     * @param pizzaName
     * @return
     */
    private Pizza orderPizza(String pizzaName) {
        Pizza pizza = createPizza(pizzaName);
        pizza.prepared();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * 每个店铺都可以自己制作具有一定特色的披萨(这里是工厂方法的实例)
     * @implNote 正是因为此方法是抽象，PizzaStore并不知道具体谁参与了CreatePizza，所以实现了解耦
     * todo 工厂方法
     * @param pizzaName 披萨名称
     * @return
     */
    abstract Pizza createPizza(String pizzaName);
}
