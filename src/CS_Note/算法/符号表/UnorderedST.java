package CS_Note.算法.符号表;

public interface UnorderedST<Key , Value> {

    public abstract Value get(Key key);

    public abstract int size();

    public abstract void put(Key key, Value value);

    public abstract void delete(Key key);
}
