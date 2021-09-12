package java_knowledge.设计模式.结构式.外观;

/**
 * 统一的简单接口
 */
public class Facade {
    private SubSystem subSystem = new SubSystem();

    public void watchMovie() {
        subSystem.turnOnTV();
        subSystem.setCD("a movie");
        subSystem.startWatching();
    }
}
