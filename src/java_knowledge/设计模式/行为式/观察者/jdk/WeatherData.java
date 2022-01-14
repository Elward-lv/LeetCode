package java_knowledge.设计模式.行为式.观察者.jdk;

import javafx.beans.InvalidationListener;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: lvyanwei
 * @Date: 2022-01-12
 */
public class WeatherData extends Observable {

    /**
     * 数据变化
     * @param x x
     * @param y y
     * @param z z
     */
    public void setData(int x, int y, int z){
        Data data = new Data(x, y, z);
        this.setChanged();
        this.notifyObservers(data);
    }
}
