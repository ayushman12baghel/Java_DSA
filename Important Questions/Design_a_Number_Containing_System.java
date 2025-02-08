import java.util.*;

class NumberContainers {
    Map<Integer, Integer> indexToNum;
    Map<Integer, TreeSet<Integer>> numToIndex;

    public NumberContainers() {
        indexToNum = new HashMap<>();
        numToIndex = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indexToNum.containsKey(index)) {
            int prevNumber = indexToNum.get(index);
            numToIndex.get(prevNumber).remove(index);
            if (numToIndex.get(prevNumber).isEmpty()) {
                numToIndex.remove(prevNumber);
            }
        }

        indexToNum.put(index, number);
        numToIndex.putIfAbsent(number, new TreeSet<>());
        numToIndex.get(number).add(index);
    }

    public int find(int number) {
        if (numToIndex.containsKey(number)) {
            return numToIndex.get(number).first();
        }

        return -1;
    }
}

class NumberContainers2 {
    Map<Integer, Integer> indexToNum;
    Map<Integer, PriorityQueue<Integer>> numToIndex;

    public NumberContainers() {
        indexToNum=new HashMap<>();
        numToIndex=new HashMap<>();
    }

    public void change(int index, int number) {
        indexToNum.put(index, number);
        numToIndex.putIfAbsent(number, new PriorityQueue<>());
        numToIndex.get(number).offer(index);
    }

    public int find(int number) {
        if (!numToIndex.containsKey(number)) {
            return -1;
        }

        PriorityQueue<Integer> pq = numToIndex.get(number);

        while (!pq.isEmpty()) {
            int current = pq.peek();
            if (indexToNum.get(current) == number) {
                return current;
            }
            pq.poll();
        }

        return -1;
    }
}

public class Design_a_Number_Containing_System {
    public static void main(String args[]) {
        NumberContainers obj = new NumberContainers();
        obj.change(1, 10);
        obj.change(2, 20);
        obj.change(1, 30);
        System.out.println(obj.find(10));
    }
}
