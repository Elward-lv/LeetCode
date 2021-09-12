package java_knowledge.设计模式.行为式.观察者;

/**
 * 主题
 */
public interface Subject {
    public abstract void registerObserve(Observer observe);

    public abstract void removeObserve(Observer observe);

    public abstract void notifyAllObserve();
}
