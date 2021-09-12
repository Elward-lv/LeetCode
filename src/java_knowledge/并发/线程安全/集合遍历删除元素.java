package java_knowledge.并发.线程安全;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 集合遍历删除元素 {
    public static void main(String[] args) {
        Integer[] arrs = {10,20,50,100,64,80,72,66};
        List<Integer> list = Arrays.asList(arrs);

        for (Integer integer : list) {
            if(integer == 72){
                list.remove(integer);
            }
        }
        System.out.println(list);
    }
}
