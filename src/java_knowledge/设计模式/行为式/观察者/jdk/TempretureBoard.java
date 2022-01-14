package java_knowledge.设计模式.行为式.观察者.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: lvyanwei
 * @Date: 2022-01-12
 */
public class TempretureBoard implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        //arg 是一个Data对象，直接可以进行转换，此时需要考虑到观察者和主题的对应关系
        System.out.println("==============");
        System.out.println(arg);
    }
}
