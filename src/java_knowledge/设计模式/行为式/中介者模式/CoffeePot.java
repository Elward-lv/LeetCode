package java_knowledge.设计模式.行为式.中介者模式;

public class CoffeePot extends Colleague {
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("coffeePot");
    }

    public void doCoffeePot(){
        System.out.println("doCoffeePot()");
    }
}
