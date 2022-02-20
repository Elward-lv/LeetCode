package java_knowledge.泛型;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型通配符的使用？，当通配符作为参数的时候并不能添加任意对象，反而编译不通过
 * List的方法失效
 * @Author: lvyanwei
 * @Date: 2022-02-20
 */
public class TWildcardCharacterTest {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        method(arr);

    }

    public static void method(List<?> arr){
        //do nothing
        //arr.add("hello"); //编译失败
    }
}
