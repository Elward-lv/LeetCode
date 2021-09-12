package java_knowledge.设计模式.创建式.原型模式;

public class Client {
    public static void main(String[] args) {
        ConcretePrototype1 hello = new ConcretePrototype1("hello");
        Prototype clone = hello.myClone();
        System.out.println("hello:hashcode-"+hello.hashCode()+",field-"+hello.toString());
        System.out.println("clone:hashcode-"+clone.hashCode()+",field-"+clone.toString());
    }
}
