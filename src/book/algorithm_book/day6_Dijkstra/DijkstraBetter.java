package book.algorithm_book.day6_Dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
* 改进了的Dijkstra算法
*
* 结果：ok
* 改进地方：只需要指出起点，终点，即可完成路劲的查找
* */
public class DijkstraBetter {
    public static void main(String[]  args){
        Map<String, Map<String, Integer>> graph = initMap();
        Map<String,Integer> costs = new HashMap<>();
        Map<String,String> parents = new HashMap<>();
        ArrayList<String> processed = new ArrayList<>();

        DijikstraTest( graph, costs ,parents, processed);
        Set<String> pts = parents.keySet();
        for (String pt : pts) {
            System.out.println(pt+","+parents.get(pt));
        }
    }

    /**
     * 算法,开始节点为起点
     * @param graph 图
     * @param costs 花销
     * @param processed 父节点,保存路径
     */
    private static void DijikstraTest(Map<String, Map<String, Integer>> graph, Map<String, Integer> costs, Map<String,String > parents,ArrayList<String> processed) {
        //算法开始：将初始邻居加入costs和parents
        costs.put("终点",10000);
        //循环找到costs中最小花费的节点并处理
        String node = "起点";
        while(node != null){
            int cost = 0;
            if(costs.get(node) != null){//起点到最小节点的cost
                cost = costs.get(node);
            }

            Map<String, Integer> neighboor = graph.get(node);
            Set<String> nextSet = neighboor.keySet();
            for (String s : nextSet) {
                int new_cost = cost + neighboor.get(s);
                if(costs.get(s) == null){
                    //costs中不含有此节点，把此节点加入costs，花销即为上边计算的new_cost
                    costs.put(s,new_cost);
                    parents.put(s,node);
                }
                else if(new_cost < costs.get(s)){
                    costs.put(s,new_cost);
                    parents.put(s,node);
                }
            }
            processed.add(node);
            node = findSmallCosts(costs,processed);
        }
    }

    /**
     * 找到costs中最小花费的节点
     * @param costs
     * @param processed
     * @return
     */
    public static String findSmallCosts(Map<String, Integer> costs,ArrayList<String> processed){
        Set<String> sets = costs.keySet();
        String res = null;
        int cost = 1000;
        for (String set : sets) {
            //花销最小&&没处理过&&不是终点标志
            if(cost > costs.get(set) && !processed.contains(set) && !set.equals("终点")){
                res = set;
                cost = costs.get(set);
            }
        }
        return res;
    }
    //初始化图
    public static Map<String, Map<String,Integer>>  initMap(){
        Map<String, Map<String,Integer>> graph = new HashMap<>();
        graph.put("起点",createArraylistByArrs(new String[]{"A", "B"},new Integer[]{6,2}));
        graph.put("A",createArraylistByArrs(new String[]{"终点"},new Integer[]{1}));
        graph.put("B",createArraylistByArrs(new String[]{"A","终点"},new Integer[]{3,5}));
        graph.put("终点",createArraylistByArrs(null,null));
        return graph;
    }

    /**
     * create ArrayList<String,Map(String,Integer)> by two arrays
     * @param arrs String数组
     * @param costs Integer数组
     * @return list 创建的ArrayList<String>
     */
    public static Map<String,Integer> createArraylistByArrs(String[] arrs,Integer[] costs){
        if(arrs == null || costs ==null || arrs.length!= costs.length){
            return null;
        }
        Map<String,Integer> dest = new HashMap<>();
        for (int i = 0; i < arrs.length; i++) {
            dest.put(arrs[i],costs[i]);
        }
        return dest;
    }

    /**
     * 测试图中数据是否正确
     * @param graph 图的MAP
     * @param st 测试的起点
     */
    public static void  testGraph(Map<String, Map<String, Integer>> graph,String st){
        Map<String, Integer> start = graph.get(st);
        Set<String> set = start.keySet();
        for(String s:set){
            Integer integer = start.get(s);
            System.out.println(st+" to "+s+" cost:"+integer);
        }
    }
}
