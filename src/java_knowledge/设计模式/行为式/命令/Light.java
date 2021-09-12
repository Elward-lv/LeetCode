package java_knowledge.设计模式.行为式.命令;

/**
 * 命令的执行者
 */
public class Light {

    public void on(){
        System.out.println("灯打开了");
    }

    public void off() {
        System.out.println("Light is off!");
    }
}
