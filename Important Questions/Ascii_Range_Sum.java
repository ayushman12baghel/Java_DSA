import java.util.*;

public class Ascii_Range_Sum {

    // Brute Force O(n)
    public static List<Integer> asciirange(String s) {
        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, new int[] { i, i });
            } else {
                map.get(ch)[1] = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            char key = entry.getKey();
            int value[] = entry.getValue();
            int start = value[0];
            int end = value[1];

            if (start + 1 < end) {
                int sum = 0;
                for (int i = start + 1; i < end; i++) {
                    sum += (int) s.charAt(i);
                }

                if (sum > 0) {
                    ans.add(sum);
                }
            }
        }

        return ans;
    }

    // Somewhat More Optimised Using PrefixSum
    public static List<Integer> asciirange2(String s) {
        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, new int[] { i, i });
            } else {
                map.get(ch)[1] = i;
            }
        }

        int prefixSum[] = new int[s.length()];
        prefixSum[0] = (int) s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            prefixSum[i] = prefixSum[i - 1] + (int) s.charAt(i);
        }

        List<Integer> ans = new ArrayList<>();

        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            char key = entry.getKey();
            int value[] = entry.getValue();
            int start = value[0];
            int end = value[1];

            if (start + 1 < end) {
                int sum = prefixSum[end - 1] - prefixSum[start];

                if (sum > 0) {
                    ans.add(sum);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abacab";

        System.out.println(asciirange(s));
        System.out.println(asciirange2(s));
    }
}
