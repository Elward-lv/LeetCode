package java_knowledge.设计模式.结构式.适配器;

public class Client {
    public static void main(String[] args) {
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(new WildTurkey());
//        quack方法是鸭子发出的声音
        turkeyAdapter.quack();
    }
}
