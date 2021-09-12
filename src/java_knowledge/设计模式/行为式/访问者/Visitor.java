package java_knowledge.设计模式.行为式.访问者;

public interface Visitor {
    void visit(Customer customer);

    void visit(Order order);

    void visit(Item item);
}
