package java_knowledge.泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * 用来测试泛型 -- 父类可不可以用于子类的泛型的问题
 * @Author: lvyanwei
 * @Date: 2022-02-20
 */
public class TParentToChildTest {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();
        //method(numbers); //编译错误,不能传入父类
    }

    public static void method(List<Integer> param){
        //do nothing
    }
    //重载的话编译出错和方法一重复
    /*public static void method(List<Number> param){
        //do nothing
    }*/
}
