package newCoder;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1.使用简单的遍历即可求出两数的位置
 * 2.使用hash来计算
 *      思路：map里面放 键为target-每个数的结果 值为下标
 */
public class 和的加数位置计算 {
    public static void main(String[] args) {
        int[] p = {3,2,4};
        Solution s = new Solution();

        //calucate time
        long start = System.currentTimeMillis();
        int[] res = s.twoSum(p, 6);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(res)+" , time:"+(end - start));

        int[] res2 = new Solution2().twoSum(p, 6);
        System.out.println(Arrays.toString(res2));

    }

}

class Solution2 {
    public int[] twoSum (int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0 ; i< numbers.length ; i++){
            if(map.containsKey(numbers[i])){
                res[0] = map.get(numbers[i]) + 1;
                res[1] = i+1;
                return res;
            }else {
                map.put(target- numbers[i] , i);
            }
        }
        return null;
    }
}

class Solution {
    /**
     * 下标从1开始
     * 整数数组 num[i]无范围
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int [] res = new int[2];
        //找到第一个小于此数的数组位置
        for(int i = 0; i < numbers.length ; i++ ){
            /**
             * 总结：这里由于对于i++的忽视导致最终计算不正确
             */
            res[0] = i+1;
            int j = i+1 ;
            if( ( j = searchNext( target - numbers[i] , i+1 , numbers) ) !=  0 ){
                //find next and return
                res[1] = j+1 ;
                return res;
            }

        }
        return res;
    }

    public  int searchNext(int num , int start , int[] value){
        for(int k = start ; k < value.length ; k++){
            if( num == value[k] ){
                return k;
            }
        }
        return 0;
    }
}
