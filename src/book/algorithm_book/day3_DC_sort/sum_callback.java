package book.algorithm_book.day3_DC_sort;

/**
 * 递归求和
 */
public class sum_callback {
    public static void main(String[] args) {
        int[] arrs = {10,20,30,40,50};
        int sum = sum(arrs ,arrs.length-1);
        System.out.println(sum);
    }

    private static int sum(int[] arrs, int i) {
        if(i == 0){
            return arrs[i];
        }
        else
            return arrs[i]+sum(arrs , i-1);
    }
}
