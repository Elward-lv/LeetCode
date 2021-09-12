package book.algorithm_book.day5_bfs;

import java.util.*;

/**
 * 广度优先搜索BFS：
 * 图的表示：使用散列表
 *
 * 算法流程：
 *      初始化队列为1级邻居
 *      队列非空且没有到达目标时，持续循环
 *      每次循环都检查是否到达终点，并把其邻居入对
 *          到达即结束
 *          否则弹出此元素，继续循环
 * 实现 结果：ok
 */
public class bfs_undirect {
    public static void main(String[] args) {
        //testQueue();
        Map<String, ArrayList<String>> map = initMap();
        String bfs = BFS(map, "you", 'j');
        System.out.println(bfs);  //thom
    }

    public static Map<String, ArrayList<String>> initMap(){
        Map<String, ArrayList<String>> map = new HashMap<>();
        map.put("you",createListByArrs(new String[]{"alice", "bob", "claire"}));
        map.put("bob",createListByArrs(new String[]{"anuj", "peggy"}));
        map.put("claire",createListByArrs(new String[]{"peggy"}));
        map.put("anuj",createListByArrs(new String[]{"thom", "jonny"}));
        map.put("alice",createListByArrs(null));
        map.put("peggy",createListByArrs(null));
        map.put("thom",createListByArrs(null));
        map.put("jonny",createListByArrs(null));
        return map;
    }

    /**
     * BFS 开始从you开始
     * @param map 传入的图（用 map表示）
     * @param start 第一次进入队列的map中的数组 也就是查询开始的位置
     * @param pattern 查找的结果---这里根据查询到的String的字符结尾字符来判断是否结束,当然可以使用其他方法
     */
    public static String  BFS(Map<String, ArrayList<String>> map , String start ,Character pattern){
        Queue<String> queue = new ArrayDeque<>();
        ArrayList<String> list = map.get(start);
        for (String s : list) {
            queue.add(s);
        }
        while (!queue.isEmpty()){
            String remove = queue.remove();
            boolean res = check(remove, pattern);
            if(res){
                return remove;
            }else {
                ArrayList<String> childs = map.get(remove);
                if(childs == null || childs.size() ==0){
                    continue;
                }
                for (String child : childs) {
                    queue.add(child);
                }
            }
        }
        return null;
    }

    /**
     * 检查 是否符合条件
     * @param s 字符串
     * @param character 结尾包含的结果字符
     * @return 检查结果
     */
    public static boolean check(String s , Character  character){
        String end = character+"";
        if(s.endsWith(end)){
            return true;
        }
        return false;
    }

    /**
     * create ArrayList by String[]
     * @param arrs String数组
     * @return list 创建的ArrayList<String>
     */
    public static ArrayList<String> createListByArrs(String[] arrs){
        if(arrs == null){
            return null;
        }
        ArrayList<String> list = new ArrayList<>();
        for (String arr : arrs) {
            list.add(arr);
        }
        return list;
    }

    public static void testQueue(){
        Queue<String> queue = new ArrayDeque<>();// hello1  hello2  hello3
        queue.add("hello3");
        queue.add("hello2");
        queue.add("hello1");
        String remove = queue.remove();
        System.out.println(remove);//hello3
    }

}
