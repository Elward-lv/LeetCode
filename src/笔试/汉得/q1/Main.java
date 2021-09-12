package 笔试.汉得.q1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 某城市环路设有新能源充电站点N个，其中第i个充电站点可供充电的电量为electronic[i]Kwh，现假设，
 * 你有一辆可以无限充电的电动汽车，从第i个充电桩开往第i+1个站点需要耗电cost[i]Kwh。
 * 该车从环路线路的某一充电站出发，开始时该电车空电量，若如果该电车可以绕环路行驶一周，则返回出发时充电站点编号，否则返回-1
 * <p>
 * 输入数组均为非空数组，且长度相同。
 * <p>
 * 输入数组中的元素均为非负数。
 * <p>
 * 输入的两组数组中的间隔为空格
 * <p>
 * 1,2,3,4,5 3,4,5,1,2 in
 * 3 out
 */
public class Main {
    /**
     * 思路：找出发站点编号，找不到返回-1，并且车子电量(无限充电)可以行驶一周
     *
     * @param args
     */
    public static void main(String[] args) {
        //resolve the input
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arrs = input.split("\\s+");
        double[] electric = convertStringToIntArr(arrs[0].split(","));
        double[] cost = convertStringToIntArr(arrs[1].split(","));
        //模拟场景  从某个站点出发
        for (int i = 0; i < electric.length; i++) {
            int cur = i;
            int lastCur = cur;
            cur = (cur >= electric.length - 1) ? 0 : cur + 1;
            double carElec = electric[lastCur];
            while (carElec >= cost[lastCur]) {
                //电量足够到下一站
                if (cur == i) {
                    System.out.println(i);
                    return;
                } else {
                    //足够到下一站，继续走
                    carElec += electric[cur];
                    carElec -= cost[lastCur];
                }
                lastCur = cur;
                cur = (cur >= electric.length - 1) ? 0 : cur + 1;
            }
        }
        System.out.println(-1);
    }

    public static double[] convertStringToIntArr(String[] strs) {
        double[] res = new double[strs.length];
        int i = 0;
        for (String str : strs) {
            res[i++] = Double.parseDouble(str);
        }
        return res;
    }


}
