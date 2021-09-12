package newCoder;

import java.util.*;


public class SolutionTest {
    public static void main(String[] args) {
        String s = "19 5 9 255";
        System.out.println(new SolutionTest().sort(s));
    }
    /**
     *
     * @param inData string字符串 请求参数
     * @return int整型
     */
    public int sort (String inData) {
        // write code here
        String[] nums = inData.split(" ");
        int[] values = new int[nums.length];
        for (int i = 0 ;i < nums.length ; i++ ) {
            values[i] = Integer.parseInt(nums[i]);
        }
        /**
         * 插入排序？
         * 1.暴力破解--冒泡
         */
        int count = 0;
        for (int i = values.length - 1 ; i > 0 ;  i--) {
            int max = i;
            for(int j = i+1 ; j < values.length ; j++){
                if(values[j] > values[max]){
                    max = j;
                }
            }
            //compare
            if(max != i){
                int temp = values[i];
                values[i] = values[max];
                values[max] = temp;
                count++;
            }
        }
        return count;
    }
}