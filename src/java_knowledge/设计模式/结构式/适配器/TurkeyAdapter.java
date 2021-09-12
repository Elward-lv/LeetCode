package java_knowledge.设计模式.结构式.适配器;

/**
 * 命名实现的是鸭子的接口，实际上是鸡
 */
public class TurkeyAdapter implements Duck {
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }
}
