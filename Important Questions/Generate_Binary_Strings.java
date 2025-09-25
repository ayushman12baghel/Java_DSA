import java.util.*;

//O(n log n)
class Solution {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            result.add(toBinary(i));
        }

        return result;
    }

    public String toBinary(int i) {
        StringBuilder sb = new StringBuilder();

        while (i > 0) {
            sb.append(i % 2);
            i /= 2;
        }

        return sb.reverse().toString();
    }
}

// Approach 2 Using Queue
class Solution {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.offer("1");

        for (int i = 1; i <= n; i++) {
            String current = queue.poll();
            result.add(current);

            queue.offer(current + "0");
            queue.offer(current + "1");
        }

        return result;
    }
}
