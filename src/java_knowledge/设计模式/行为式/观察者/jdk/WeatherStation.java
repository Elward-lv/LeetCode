package java_knowledge.设计模式.行为式.观察者.jdk;

/**
 * jdk的 观察者模式的使用
 * @Author: lvyanwei
 * @Date: 2022-01-12
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        weatherData.addObserver(new TempretureBoard());

        weatherData.setData(10, 2, 1);
        weatherData.setData(2, 6, 4);
        weatherData.setData(3, 8, 6);
    }
}
