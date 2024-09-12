import java.util.*;

public class Last_Stone_Weight {

    public static int lastStoneWeight(int stones[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (int num : stones) {
            pq.add(num);
        }

        while (pq.size() > 1) {
            int y = pq.remove();
            int x = pq.remove();
            if (x != y) {
                pq.add(y - x);
            }
        }

        return pq.size() > 0 ? pq.remove() : 0;
    }

    public static void main(String[] args) {
        int stones[] = { 2, 7, 4, 1, 8, 1 };

        System.out.println(lastStoneWeight(stones));
    }
}
