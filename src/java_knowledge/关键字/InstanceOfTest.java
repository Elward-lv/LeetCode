package java_knowledge.关键字;

/**
 * 测试instanceOf对于子类和父类的区别
 *          对于本类或者父类，返回都是true
 */
public class InstanceOfTest {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child instanceof Parent);

        int i = 10;
        Object obj = i;
        System.out.println(obj.getClass().getName());
        System.out.println(obj instanceof Float);
    }
}

class Parent{

}
class Child extends Parent{

}