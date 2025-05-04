import java.util.*;

public class Number_of_Equivalent_Dominoes_Pairs {

    // Approach 1-> Usiing Brute Force O(n^2)
    public static int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        int count = 0;

        for (int edge[] : dominoes) {
            int first = edge[0];
            int second = edge[1];
            edge[0] = Math.min(first, second);
            edge[1] = Math.max(first, second);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1]) {
                    count++;
                }
            }
        }

        return count;
    }

    // Approach 2 Using 2 Pass O(n)
    public static int numEquivDominoPairs2(int dominoes[][]) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int edge[] : dominoes) {
            int a = Math.min(edge[0], edge[1]);
            int b = Math.max(edge[0], edge[1]);
            int key = a * 10 + b;// Because a and b lies between 1 to 9
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            count += freq * (freq - 1) / 2;
        }

        return count;
    }

    // Approach 3 Using one pass O(n)
    public static int numEquivDominoPairs3(int dominoes[][]) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int edge[] : dominoes) {
            int a = Math.min(edge[0], edge[1]);
            int b = Math.max(edge[0], edge[1]);
            String key = a + "," + b;
            int currentCount = map.getOrDefault(key, 0);
            count += currentCount;
            map.put(key, currentCount + 1);
        }

        return count;
    }

    public static void main(String args[]) {
        int dominoes[][] = { { 1, 2 }, { 1, 2 }, { 1, 1 }, { 1, 2 }, { 2, 2 } };

        System.out.println(numEquivDominoPairs(dominoes));
        System.out.println(numEquivDominoPairs2(dominoes));
        System.out.println(numEquivDominoPairs3(dominoes));
    }
}
