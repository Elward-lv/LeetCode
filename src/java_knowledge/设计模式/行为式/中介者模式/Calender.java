package java_knowledge.设计模式.行为式.中介者模式;

public class Calender extends Colleague{
    @Override
    public void onEvent(Mediator mediator) {
        mediator.doEvent("calender");
    }

    public void doCalender(){
        System.out.println("doCalender");
    }
}
