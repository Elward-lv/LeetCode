package java_knowledge.设计模式.行为式.观察者;

/**
 * 依赖即观察者
 */
public interface Observer {
    public abstract void update(float temp, float humidity, float pressure);
}
