package java_knowledge.设计模式.创建式.生成器;

public class StringBuilder extends AbstractStringBuilder {
    public StringBuilder() {
        super(16);
    }

    @Override
    public String toString() {
        return new String(values, 0 ,count);
    }
}
