package java_knowledge.设计模式.行为式.迭代器;

public interface Iterator<Item> {
    public boolean hasNext();

    Item next();
}
