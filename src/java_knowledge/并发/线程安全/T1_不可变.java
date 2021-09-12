package java_knowledge.并发.线程安全;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 演示线程安全的不可变的情况
 *      Collections.unmodifiableMap返回的集合或者map是不可变的
 */
public class T1_不可变 {
    public static void main(String[] args) {
        Map<Object,Object> map = new HashMap<>();
        map.put("name","lvyanwei");
        map.put("age",20);

        Map<Object, Object> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put("sex","女");//异常UnsupportedOperationException
    }
}
