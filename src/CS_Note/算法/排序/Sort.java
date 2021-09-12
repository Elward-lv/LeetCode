package CS_Note.算法.排序;

/**
 * 待排序的元素需要实现 Java 的 Comparable 接口，该接口有 compareTo() 方法，可以用它来判断两个元素的大小关系。
 * @param <T>
 */
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    /**
     * v<w  返回true
     * 否则 返回false
     * @param v
     * @param w
     * @return
     */
    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
