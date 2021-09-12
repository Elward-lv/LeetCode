package leetcode.editor.cn;
//两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给出两个整数 x 和 y，计算它们之间的汉明距离。 
//
// 注意： 
//0 ≤ x, y < 231.
//
// 示例: 
//
// 
//输入: x = 1, y = 4
//
//输出: 2
//
//解释:
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//
//上面的箭头指出了对应二进制位不同的位置。
// 
// Related Topics 位运算 
// 👍 367 👎 0


public class HammingDistance{
        public static void main(String[] args){
            Solution solution = new HammingDistance()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * 1.将两个数字转换为字符串，通过字符串进行比较
             *          执行耗时:12 ms,击败了9.95% 的Java用户
             * 			内存消耗:36.3 MB,击败了5.08% 的Java用户
             * 2.通过int的异或运算保存位置不同的位置为1，结果转换为string，计算1个数
             *          执行耗时:1 ms,击败了9.95% 的Java用户
             * 			内存消耗:35 MB,击败了92.73% 的Java用户
             * 3.对两个数进行异或操作，位级表示不同的那一位为 1，统计有多少个 1 即可。
             *          执行耗时:0 ms,击败了100.00% 的Java用户
             * 			内存消耗:35.3 MB,击败了35.66% 的Java用户
             * 	4.其他位操作运算都可以使用在计算1的数目上
             * @param x
             * @param y
             * @return
             */
    public int hammingDistance(int x, int y) {
        //1.
        /*if( x == y) return 0;
        String binX = Integer.toBinaryString(x);
        String binY = Integer.toBinaryString(y);
        System.out.println(binX + ", "+binY);
        int count = 0 , indexX = binX.length() - 1, indexY = binY.length() - 1;
        while (indexX >= 0 || indexY >= 0 ){
            if(indexX >= 0 && indexY >= 0 && binX.charAt(indexX) != binY.charAt(indexY)){
                count++;
            }else if(indexX >= 0 && indexY < 0 && binX.charAt(indexX) != '0'){
                count++;
            }else if(indexX < 0 && binY.charAt(indexY) != '0'){
                count++;
            }
            indexX--;
            indexY--;
        }
        return count;*/
        //2.
        /*int i = x ^ y, count = 0;
        String s = Integer.toBinaryString(i);
        for (int j = 0; j < s.length(); j++) {
            if(s.charAt(j) == '1'){
                count++;
            }
        }
        return count;*/
        //3.
        int t = x ^ y, cnt = 0;
        while (t != 0){
            if( (t & 1) == 1) cnt++;
            t = t >> 1;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}