import java.util.*;

class Node {
    int key;
    int value;
    Node next;
    Node prev;
    int freq;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
        this.freq = 1;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeLast() {
        if (size == 0) {
            return null;
        }

        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}

class LFUCache {
    int capacity;
    int minFreq;
    Map<Integer, Node> keyToNode;
    Map<Integer, DoublyLinkedList> freqToList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }

        Node node = keyToNode.get(key);
        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFreq(node);
        } else {
            if (keyToNode.size() >= capacity) {
                removeLFU();
            }

            Node newNode = new Node(key, value);
            keyToNode.put(key, newNode);
            freqToList.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(newNode);
            minFreq = 1;
        }
    }

    public void updateFreq(Node node) {
        int freq = node.freq;
        freqToList.get(freq).removeNode(node);

        if (freqToList.get(freq).size == 0) {
            freqToList.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }

        node.freq++;
        freqToList.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
    }

    public void removeLFU() {
        DoublyLinkedList list = freqToList.get(minFreq);
        Node toRemove = list.removeLast();
        keyToNode.remove(toRemove.key);
        if (list.size == 0) {
            freqToList.remove(minFreq);
        }
    }
}

public class LFU_Cache {
    public static void main(String args[]) {

    }
}