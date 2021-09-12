package CS_Note.算法.符号表.初级实现;

import CS_Note.算法.符号表.UnorderedST;

public class ListUnorderedSTTest {
    public static void main(String[] args) {
        UnorderedST<Integer, String> st = new ListUnorderedST<>();
        st.put(1,"hello");
        st.put(2,"hello2");
        st.put(3,"hello3");
        System.out.println(st.size());
        System.out.println(st.get(3));
    }
}
