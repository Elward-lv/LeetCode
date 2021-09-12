package java_knowledge.设计模式.创建式;

public class BadProduct  implements Product {
    @Override
    public void hello() {
        System.out.println("bad product!");
    }
}
