package java_knowledge.设计模式.行为式.观察者;

public class CurrentConditionsDisplay implements Observer {
    public CurrentConditionsDisplay(Subject subject) {
        subject.registerObserve(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("CurrentConditionsDisplay.update: " + temp + " " + humidity + " " + pressure);
    }
}
