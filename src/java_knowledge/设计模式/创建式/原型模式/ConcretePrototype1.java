package java_knowledge.设计模式.创建式.原型模式;

public class ConcretePrototype1 extends Prototype {

    private String filed;

    public ConcretePrototype1(String filed) {
        this.filed = filed;
    }

    @Override
    public Prototype myClone() {
        return new ConcretePrototype1(filed);
    }

    @Override
    public String toString() {
        return filed;
    }
}
