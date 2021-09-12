package java_knowledge.枚举;

/**
 * 其实枚举有点像一个Java Bean
 * 它首先继承了 Enum这个类
 */
public class Test {
    public static void main(String[] args) {
        //获取自定义属性值
        System.out.println(States.Error_100.getMsg());
        System.out.println(States.Error_100.getCode());

        //获取name
        System.out.println(States.Error_100.name());
    }
}
