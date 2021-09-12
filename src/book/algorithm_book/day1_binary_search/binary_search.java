package book.algorithm_book.day1_binary_search;

/**
 * 二分查找测试
 */
public class binary_search {
    public static void main(String[] args) {
        int[] arrs = {1,4,10,20,48,50,62};
        int i = binary_search(arrs,0);
        System.out.println(i);
    }

    public static int binary_search(int[] arrs,int res){
        int low=0;
        int high = arrs.length;
        int count=0;
        /**
         * 循环计算
         *      mid = low + high
         *      if(arrs[mid] == res)
         *          return mid
         *      else if(arrs[mid] < res)
         *          low = mid+1
         *      else
         *          high = mid -1
         * <忘记计算null的情况>
         */
        while(low <= high){
            count++;
            int mid = (low + high)/2;
            if(arrs[mid] == res){
                return mid;
            }
            else if(arrs[mid] < res){
                low = mid +1;
            }
            else if(arrs[mid] > res){
                high = mid -1;
            }
        }
        System.out.println(count);
        return -1;
    }

    //重载
    public static int binary_search(Integer[] arrs,int res){
        int low=0;
        int high = arrs.length;
        /**
         * 循环计算
         *      mid = low + high
         *      if(arrs[mid] == res)
         *          return mid
         *      else if(arrs[mid] < res)
         *          low = mid+1
         *      else
         *          high = mid -1
         * <忘记计算null的情况>
         */
        while(low <= high){
            int mid = (low + high)/2;
            if(arrs[mid] == res){
                return mid;
            }
            else if(arrs[mid] < res){
                low = mid +1;
            }
            else if(arrs[mid] > res){
                high = mid -1;
            }
        }
        return -1;
    }
}
