package 笔试;

import java.util.*;

public class 字符串去重 {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        //返回helowrd
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < words.size(); i++) {
            char[] chars = words.get(i).toCharArray();
            for (char c : chars) {
                set.add(c);
            }
        }
        char[] res = new char[set.size()];
        int index = 0;
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()) {
            res[index++] = iterator.next();
        }
        System.out.println(Arrays.toString(res));
    }
}
