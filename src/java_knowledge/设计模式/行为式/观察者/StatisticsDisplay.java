package java_knowledge.设计模式.行为式.观察者;

public class StatisticsDisplay implements Observer {
    public StatisticsDisplay(Subject subject) {
        subject.registerObserve(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        System.out.println("StatisticsDisplay.update: " + temp + " " + humidity + " " + pressure);
    }
}
