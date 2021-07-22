import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int val;
        int key;
        Node next;
        Node pre;
        Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    protected Map<Integer, Node> map;
    int size;
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<>(capacity);

    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            System.out.println(-1);
            return -1;
        }
        else {
            updateNode(node);
            System.out.println(node.val);
            return node.val;
        }
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.val = value;
            updateNode(node);
            return;
        }

        if (map.size() == this.size) {
            map.remove(head.key);
            deleteNode();
        }
        Node n = new Node(key, value);
        map.put(key, n);
        addNode(n);
    }

    private void addNode(Node node){
        if (tail == null) {
            head = node;
            tail = node;
            tail.next = head;
            tail.pre = head;
            head.next = tail;
            head.pre = tail;
        } else {
            node.next = head;
            node.pre = tail;
            tail.next = node;
            tail = node;
            head.pre = node;
        }
    }

    private void updateNode (Node node) {
        if (node == tail) return;
        else if (node == head) {
            head = head.next;
            tail = tail.next;
            return;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            tail.next = node;
            node.pre = tail;
            node.next = head;
            head.pre = node;
            tail = node;
        }
    }

    private void deleteNode () {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.pre = tail;
            tail.next = head;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        cache.get(13);
        cache.put(2, 19);
        cache.get(2);
        cache.get(3);
        cache.put(5, 25);
        cache.get(8);
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        cache.get(11);
        cache.put(9, 12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);
        cache.put(4, 30);
        cache.put(9, 3);
        cache.get(9);
        cache.get(10);
        cache.get(10);
        cache.put(6, 14);
        cache.put(3, 1);
        cache.get(3);
        cache.put(10, 11);
        cache.get(8);
        cache.put(2, 14);
        cache.get(1);
        cache.get(5);
        cache.get(4);
        cache.put(11, 4);
        cache.put(12, 24);
        cache.put(5, 18);
        cache.get(13);
        cache.put(7, 23);
        cache.get(8);
        cache.get(12);
        cache.put(3, 27);
        cache.put(2, 12);
        cache.get(5);
        cache.put(2, 9);
        cache.put(13, 4);
        cache.put(8, 18);
        cache.put(1, 7);
        cache.get(6);

    }
}
