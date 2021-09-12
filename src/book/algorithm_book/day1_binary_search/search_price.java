package book.algorithm_book.day1_binary_search;

import java.util.*;

/**
 * 数组的每个元素包含两项内容：商品名和价格。如果将这个数组按商品名排序，就可使
 * 用二分查找在其中查找商品的价格。这样查找价格的时间将为O(log n)。
 * 使用数据结构：
 *      1.Map<String,Integer>仅仅通过数组索引对应,通过把key抽取出来建立数组，查询商品名称的价格
 *      2.使用数组的对应关系,通过建立一张Map包含hashcode和price的关系来查询
 * 问题：如何使String排序？
 *      可以根据String的hashcode
 */
public class search_price {
    private static String[] names= {"西红柿","土豆","红烧肉","被子","算法书","电灯","漫画"};
    private static ArrayList<Integer> namesList = new ArrayList<>();

    private static int[] prices= {40,50,60,10,35,41,90};
    private static Map<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        init();
        System.out.println("输入要查询的商品名称:");
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        int code = next.hashCode();
        System.out.println("code:"+code);

        //需要先排序，然后查找
        Collections.sort(namesList);

        System.out.println(namesList);
        Integer[] arrs = new Integer[names.length];
        namesList.toArray(arrs);

        int i = binary_search.binary_search(arrs, code);
        System.out.println("i:"+i);
        Integer res = map.get(arrs[i]);
        System.out.println("价格res:"+res);
    }

    public static void init(){
        for (int i = 0; i < names.length; i++) {
            map.put(names[i].hashCode(),prices[i]);
            namesList.add(names[i].hashCode());
        }
    }
}
