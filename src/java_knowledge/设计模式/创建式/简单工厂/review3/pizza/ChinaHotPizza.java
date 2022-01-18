package java_knowledge.设计模式.创建式.简单工厂.review3.pizza;

/**
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public class ChinaHotPizza extends Pizza {

    public ChinaHotPizza() {
        this.name = "ChinaHotPizza";
    }

    @Override
    public void prepared() {
        System.out.println(name + " is prepared ..");
    }

    @Override
    public void bake() {
        System.out.println(name + " is prepared ..");
    }

    @Override
    public void cut() {
        System.out.println(name + " is prepared ..");
    }

    @Override
    public void box() {
        System.out.println(name + " is prepared ..");
    }
}
