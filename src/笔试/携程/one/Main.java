package 笔试.携程.one;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * 新春红包礼盒由一些额度不完全相同的小红包组成，用数组 packets 来表示每一份小红包的额度。
 *
 * 你打算和 n 位朋友一同分享红包，所以你将红包拆分为 n + 1 份，每一份都由一些连续的小红包组成。
 *
 * 作为发起人，你总是会拿取总额最小的那份，剩余的几份由朋友随机抽取。
 *
 * 请找出一个最佳的拆分策略，使得你所分得的红包总额在可能的拆分策略中最大，返回这个最大总额。
 *
 * in:
 * [1,2,3,4,5,6,7,8,9]
 *
 * 5
 *
 * out：
 * 输出：6
 *
 * 解释：
 *
 * 你可以把红包拆分成 [1,2,3], [4,5], [6], [7], [8], [9]，共6份，你拿总额最小的那份即[1,2,3]，其总额为1+2+3=6。
 * 提示：
 * 1. 将数组分割成n+1组， 每组为一个连续子序列
 * 2. 求每组子序列和， 使得最小那组子序列之和在所有可能的分割方案中值最大
 */
public class Main {


    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static int maxAmount(int[] packets, int n) {
        Arrays.sort(packets);
        int res = 0;
        //当人数过多的时候
        if(packets.length <= n + 1){
            return packets[0];
        }
        //正常人数

        return res;
    }

    /******************************结束写代码******************************/

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int[] packets = stringToIntegerArray(in.nextLine().trim());
        int n = Integer.parseInt(in.nextLine().trim());

        int res = maxAmount(packets, n);
        System.out.println(res);
    }

    public static int[] stringToIntegerArray(String in) {
        in = in.trim();
        in = in.substring(1, in.length() - 1);
        if (in.length() == 0) {
            return new int[0];
        }

        String[] arr = in.split(",");
        int[] out = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            out[i] = Integer.parseInt(arr[i].trim());
        }
        return out;
    }
}
