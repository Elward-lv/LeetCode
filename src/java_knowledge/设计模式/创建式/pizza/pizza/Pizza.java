package java_knowledge.设计模式.创建式.pizza.pizza;

import java_knowledge.设计模式.创建式.pizza.ingredient.Dough;
import java_knowledge.设计模式.创建式.pizza.ingredient.Sauce;
import java_knowledge.设计模式.创建式.pizza.ingredient.factory.PizzaIngredientFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 披萨超类
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public abstract class Pizza {

    /**
     * 原料工厂
     */
    PizzaIngredientFactory ingredientFactory;

    /**
     * 名称
     * todo default 关键字允许同包 的类中调用
     */
    String name;

    /**
     * 酱料
     */
    Dough dough;

    /**
     * 调料
     */
    Sauce sauce;

    /**
     * 佐料
     */
    List<String> toppings = new ArrayList<>();

    /**
     * 披萨必须指定原料工厂
     * todo 这里我提取出来到抽象类之中可以保证每个披萨都能有原料工厂
     * @param ingredientFactory 原料工厂
     */
    public Pizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    /**
     * 准备以上东西
     */
    public abstract void prepared();

    public void bake(){
        System.out.println(" Bake for 25 minutes or long");
    }

    public void cut(){
        System.out.println(" Cut for 5 minutes or long");
    }

    public void box(){
        System.out.println(" Boxed for 10 minutes or long");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "ingredientFactory=" + ingredientFactory +
                ", name='" + name + '\'' +
                ", dough=" + dough +
                ", sauce=" + sauce +
                ", toppings=" + toppings +
                '}';
    }
}
