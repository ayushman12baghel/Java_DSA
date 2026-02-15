import java.util.*;

class MyHashMap {
    private class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    LinkedList<Node> buckets[];
    int N;
    int n;

    public MyHashMap() {
        N = 4;
        buckets = new LinkedList[N];
        n = 0;

        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int key) {
        return (key & 0x7fffffff) % N;
    }

    private int searchInLL(int key, int bi) {
        LinkedList<Node> list = buckets[bi];

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).key == key) {
                return i;
            }
        }

        return -1;
    }

    private void rehash() {
        LinkedList<Node> oldBucket[] = buckets;
        N *= 2;
        buckets = new LinkedList[N];

        for (int i = 0; i < N; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < oldBucket.length; i++) {
            for (Node node : oldBucket[i]) {
                put(node.key, node.value);
            }
        }
    }

    public void put(int key, int value) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di == -1) {
            buckets[bi].add(new Node(key, value));
            n++;
        } else {
            buckets[bi].get(di).value = value;
        }

        if ((double) n / N > 2) {
            rehash();
        }
    }

    public int get(int key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di == -1) {
            return -1;
        } else {
            return buckets[bi].get(di).value;
        }
    }

    public void remove(int key) {
        int bi = hashFunction(key);
        int di = searchInLL(key, bi);

        if (di != -1) {
            buckets[bi].remove(di);
            n--;
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */