import java.util.*;

class minHeap {
    List<Integer> arr;

    public minHeap() {
        arr = new ArrayList<>();
    }

    public void push(int x) {
        arr.add(x);

        int child = arr.size() - 1;
        int par = (child - 1) / 2;

        while (arr.get(child) < arr.get(par)) {
            int temp = arr.get(child);
            arr.set(child, arr.get(par));
            arr.set(par, temp);

            child = par;
            par = (child - 1) / 2;
        }
    }

    public void pop() {
        int data = arr.get(0);

        arr.set(0, arr.get(arr.size() - 1));
        arr.set(arr.size() - 1, data);
        arr.remove(arr.size() - 1);

        heapify(0);
    }

    public void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int minIndex = i;

        if (left < arr.size() && arr.get(left) < arr.get(minIndex)) {
            minIndex = left;
        }

        if (right < arr.size() && arr.get(right) < arr.get(minIndex)) {
            minIndex = right;
        }

        if (minIndex != i) {
            int temp = arr.get(i);
            arr.set(i, arr.get(minIndex));
            arr.set(minIndex, temp);

            heapify(minIndex);
        }
    }

    public int peek() {
        return arr.size() > 0 ? arr.get(0) : -1;
    }

    public int size() {
        return arr.size();
    }
}