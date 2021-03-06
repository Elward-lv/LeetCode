package java_knowledge.设计模式.行为式.命令;

public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();

        Light light = new Light();
        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);
        invoker.setOnCommand(lightOnCommand, 0);
        invoker.setOffCommand(lightOffCommand, 0);

        invoker.onButtonWasPushed(0);
        invoker.offButtonWasPushed(0);
    }
}
