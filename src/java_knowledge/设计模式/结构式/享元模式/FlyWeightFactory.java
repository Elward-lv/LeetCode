package java_knowledge.设计模式.结构式.享元模式;

import java.util.HashMap;

public class FlyWeightFactory {
    private HashMap<String, FlyWeight> flyweights = new HashMap<>();

    FlyWeight getFlyweight(String intrinsicState) {
        if (!flyweights.containsKey(intrinsicState)) {
            FlyWeight flyweight = new ConcreteFlyWeight(intrinsicState);
            flyweights.put(intrinsicState, flyweight);
        }
        return flyweights.get(intrinsicState);
    }
}
