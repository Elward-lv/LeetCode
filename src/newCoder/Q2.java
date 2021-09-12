package newCoder;

public class Q2 {
    public static void main(String[] args) {
        int res = new Q2().findGreatestSumOfSubArray(null);
    }
    /**
     * 求连续子数组的最大和
     * @param array string字符串一维数组 数组
     * @return int整型
     */
    public int findGreatestSumOfSubArray (String[] array) {
        // write code here
        int[] nums = new int[array.length];
        //trans to nums
        int i = 0;
        for (String s : array) {
            nums[i] = Integer.parseInt(s);
            i++;
        }
        //count max sub sequences
        int start = 0;
        int count = 0;
        int fuhao = 0;
        for (int j = 0; j < nums.length; j++) {
            int k = 0;
            int e = nums[j+1] - nums[j];
            if(Math.abs(e) == 1 ){
                while (e == nums[j+1] - nums[j]){
                    k++;
                    if(count < k){
                        start =
                        count = k;
                        fuhao = e;
                    }
                }
            }
        }
        return 0;
    }
}
