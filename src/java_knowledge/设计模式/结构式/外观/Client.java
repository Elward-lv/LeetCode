package java_knowledge.设计模式.结构式.外观;

/**
 * 最少知识原则：只和你的密友谈话。也就是说客户对象所需要交互的对象应当尽可能少。
 */
public class Client {
    public static void main(String[] args) {
        new Facade().watchMovie();
    }
}
