package 笔试.阿里;

import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            //计算每组的结果
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(calculateRes(a, b, c));
        }*/
        System.out.println(calculateRes(2, 6, 5));
    }

    /**
     * 若干次操作使a和b的值等于c，每次可以取反一位
     * 最少多少次取反能让a|b = c
     *
     * 思路：1.每次取得c的最高位根据这个位 去查看a b是否对应有相应的1即可--位运算
     * 2.使用字符数组,依次从最低位开始比较,这样的话情况会少，有时候需要反转两位1才能为0
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int calculateRes(int a, int b ,int c){
        if((a|b) == c) return 0;
        //取得最高位
        String ab = Integer.toBinaryString(a | b);
        String abyh = Integer.toBinaryString(a ^ b);
        String cs = Integer.toBinaryString(c);
        int res = 0, i = ab.length()-1 , j = cs.length()-1 , zh = abyh.length();
        while (j >= 0){
            if(i < 0){
                //i < j
                if(cs.charAt(j--) != '0'){
                    res++;
                }
            }else {
                int now = cs.length() - 1 - j;
                if(cs.charAt(j) == '0' && zh - now >= 0 && abyh.charAt(zh-now) == '0'){
                    res += 2;
                    j--;
                    i--;
                } else if(cs.charAt(j--) != ab.charAt(i--)){
                    res++;
                }
            }
        }
        //i > j
        while (i >= 0){
            if(ab.charAt(i--) != '0') res++;
        }
        return res;
    }
}
