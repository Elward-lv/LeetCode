package java_knowledge.test;

public class 双重循环 {
    public static void main(String[] args) {
        int x = 3, y = 5;
        /**
         * 3: 0000 0011
         * 5: 0000 0101
         * ^
         * res:6 -> 0000 0110
         */
        System.out.println(x ^ y);

        int[][] ret = new int[4][3];
        System.out.println(ret.length+","+ret[0].length);

        float f = x * 0.5f;
        int z = (int)f;
        System.out.println(f +","+ z);
    }
}
