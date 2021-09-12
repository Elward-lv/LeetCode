package java_knowledge.设计模式.行为式.中介者模式;

public class Sprinkler extends Colleague {
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("sprinkler");
    }

    public void doSprinkler(){
        System.out.println("doSprinkler");
    }
}
