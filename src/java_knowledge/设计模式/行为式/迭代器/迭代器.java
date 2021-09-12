package java_knowledge.设计模式.行为式.迭代器;

/**
 * 迭代器实现,模仿Java中迭代器
 *
 * java.util.Iterator
 * java.util.Enumeration
 */
public class 迭代器 {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        Iterator iterator = aggregate.createIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
