package CS_Note.算法.符号表.初级实现;

import CS_Note.算法.符号表.UnorderedST;

public class ListUnorderedST<Key , Value> implements UnorderedST<Key, Value> {

    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    @Override
    public Value get(Key key) {
        Node node = first;
        while (node != null){
            if( node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public int size() {
        int cnt = 0;
        Node node = first;
        while (node != null){
            cnt++;
            node = node.next;
        }
        return cnt;
    }

    /**
     * 注意：考虑得全面一点，比如比较使用equals进行比较
     * 其次使用头插法时first有可能忘记修改...
     * @param key
     * @param value
     */
    @Override
    public void put(Key key, Value value) {
        // 如果在链表中找到节点的键等于 key 就更新这个节点的值为 value
        Node cur = first;
        while (cur != null){
            if(cur.key.equals(key)){
                cur.value = value;
                return;
            }
            cur = cur.next;
        }
        //找不到，添加新的节点,头查发
        first = new Node(key, value, first);
    }

    @Override
    public void delete(Key key) {
        if (first == null)
            return;
        if (first.key.equals(key))
            first = first.next;

        Node last = first;
        Node cur = first.next;
        while (cur != null) {
            if(cur.key.equals(key)){
                last.next = cur.next;
                return;
            }
            last = last.next;
            cur = cur.next;
        }
    }

}
