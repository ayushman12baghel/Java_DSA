public class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private Node head;
    private Node tail;
    private int currentCapacity;
    private int capacity;
    private HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        currentCapacity = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key).value;
            updateAtFront(key);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            updateAtFront(key);
            map.get(key).value = value;
        } else {
            if (map.size() < capacity) {
                currentCapacity++;
                insertAtFront(key, value);
                map.put(key, head.next);
            } else {
                Node temp = tail.prev;
                Node pre = temp.prev;
                tail.prev = pre;
                pre.next = tail;
                map.remove(temp.key);
                insertAtFront(key, value);
                map.put(key, head.next);
            }
        }
    }

    public void updateAtFront(int key) {
        Node address = map.get(key);
        Node next = address.next;
        Node prev = address.prev;
        prev.next = next;
        next.prev = prev;

        Node currentHead = head.next;
        head.next = address;
        address.next = currentHead;
        address.prev = head;
        currentHead.prev = address;
        map.put(key, address);
    }

    public void insertAtFront(int key, int value) {
        Node curr = new Node(key, value);
        Node prevHead = head.next;
        head.next = curr;
        curr.next = prevHead;
        prevHead.prev = curr;
        curr.prev = head;
        map.put(key, curr);
    }
}
