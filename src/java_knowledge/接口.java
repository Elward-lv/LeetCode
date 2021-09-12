package java_knowledge;

/**
 * 接口中可以定义以下方法：
 *      抽象方法
 *      静态方法
 *      默认方法
 *      私有方法
 *      静态私有方法
 *     除了抽象方法，其他均有方法体
 */
public interface 接口 {
    public abstract void sayHello();


    private static void setName(){

    }

    default void def(String name){
        System.out.println("hello,"+name);
    }

    private void test(){

    }

    static void testStattic(){

    }
}
