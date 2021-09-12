package CS_Note.算法.符号表;

import java.util.List;

public interface OrderedST<Key extends Comparable<Key>, Value> {
    public abstract Value get(Key key);

    public abstract void put(Key key , Value value);

    public abstract int size();

    public abstract Key min();

    public abstract Key max();

    int rank(Key key);

    List<Key> keys(Key l, Key h);
}
