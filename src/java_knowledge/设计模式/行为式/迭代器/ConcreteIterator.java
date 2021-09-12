package java_knowledge.设计模式.行为式.迭代器;

public class ConcreteIterator<Item> implements Iterator {
    private Item[] items;
    private int position = 0;

    public ConcreteIterator(Item[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position<items.length;
    }

    @Override
    public Object next() {
        return items[position++];
    }
}
