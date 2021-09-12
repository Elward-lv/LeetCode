package java_knowledge.设计模式.结构式.适配器;

public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gobble!");
    }
}
