package java_knowledge.设计模式.创建式.简单工厂.review3.pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * 披萨超类
 * @Author: lvyanwei
 * @Date: 2022-01-18
 */
public abstract class Pizza {

    /**
     * 名称
     * todo default 关键字允许同包 的类中调用
     */
    String name;

    /**
     * 酱料
     */
    String dough;

    /**
     * 调料
     */
    String sauce;

    /**
     * 佐料
     */
    List<String> toppings = new ArrayList<>();

    /**
     * 准备以上东西
     */
    public abstract void prepared();

    public abstract void bake();

    public abstract void cut();

    public abstract void box();

    public String getName() {
        return name;
    }
}
