package java_knowledge.设计模式.行为式.观察者;

import java.util.LinkedList;
import java.util.List;

/**
 * 天气数据布告板会在天气信息发生改变时更新其内容，布告板有多个，并且在将来会继续增加。
 */
public class WeatherData implements Subject {
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new LinkedList<Observer>();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyAllObserve();
    }

    @Override
    public void registerObserve(Observer observe) {
        observers.add(observe);
    }

    @Override
    public void removeObserve(Observer observe) {
        int i = observers.indexOf(observe);
        if(i>0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyAllObserve() {
        for (Observer o : observers) {
            o.update(temperature, humidity, pressure);
        }
    }
}
