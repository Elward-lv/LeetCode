package book.algorithm_book.day7_greed;

import java.util.*;

/**
 * 贪婪算法demo
 *      数据结构：hashSet
 *          Map<String,String[]> stations:电台-覆盖州的集合 string数组中元素不能重复
 *          HashSet<String>  states_for_station:此station覆盖的州
 *          HashSet<String>  states_needed：目前已加入站台还未覆盖的州,开始是全部州
 *          HashSet<String> states_covered: 是当前站台覆盖未覆盖州的集合
 *      题目：寻找能覆盖最多州的广播电台之和
 *      思想：
 *          每次遍历从中选择覆盖了最多的未覆盖州的广播台
 *          然后加入 选用站台
 *          直到
 *      HashSet的迭代：
 *          迭代器使用
 *    结果：ok
 */
public class Greed {
    public static void main(String[] args){
        Map<String,String[]> stations = new HashMap<>();
        stations.put("①",new String[]{"ID","NV","UT"});
        stations.put("②",new String[]{"WA","MT","ID"});
        stations.put("③",new String[]{"OR","NV","CA"});
        stations.put("④",new String[]{"NV","UT"});
        stations.put("⑤",new String[]{"CA","AZ"});
        stations.put("⑥",new String[]{"ID","MT","OR","MM"});

        HashSet<String> res_stations = new HashSet<>();
        greed(stations,res_stations);
        for (String res : res_stations) {
            System.out.println(res);
        }
    }

    public static void greed(Map<String,String[]> stations, HashSet<String> res_stations){
        HashSet<String>  states_needed = new HashSet<>();
        Set<String> keySet = stations.keySet();
        ArrayList<String> states = new ArrayList<>();
        for (String s : keySet) {
            states.add(s);
            states_needed.addAll(Arrays.asList(stations.get(s)));
        }

        String best_station = states.get(0);
        while (states_needed.size() != 0){
            HashSet<String>  states_for_station = getStationStates(stations.get(best_station));
            HashSet<String> states_covered = interStates(states_needed,states_for_station);//最好站点覆盖的州集合

            for (String station : keySet) {
                if(!res_stations.contains(station) && !station.equals(best_station)){
                    states_for_station = getStationStates(stations.get(station));//获得当前站台覆盖的州
                    HashSet<String> covered = interStates(states_needed,states_for_station);
                    if(covered.size() > states_covered.size() ){
                        best_station = station;
                        states_covered = covered;
                    }
                }
            }

            states_needed = subOfTwoStates(states_needed , states_covered);
            res_stations.add(best_station);

        }
    }

    public static HashSet<String> subOfTwoStates(HashSet<String> main,HashSet<String> other){
        HashSet<String> sub = new HashSet<>();
        for (String state : main) {
            if (!other.contains(state)) {
                sub.add(state);
            }
        }
        return sub;
    }

    private static HashSet<String> interStates(HashSet<String> states_needed, HashSet<String> states_for_station) {
        HashSet<String> covered = new HashSet<>();
        for (String s : states_for_station) {
            if (states_needed.contains(s)) {
                covered.add(s);
            }
        }
        return covered;
    }

    public static HashSet<String> getStationStates(String[] strs){
        HashSet<String>  states_for_station = new HashSet<>();
        Collections.addAll(states_for_station, strs);
        return states_for_station;
    }
}
