import java.util.*;

//Approach 1 O(n*m) Time and O(n) space
class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int m = bank[0].length();
        List<Integer> count = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int countOne = 0;
            for (char c : bank[i].toCharArray()) {
                if (c == '1') {
                    countOne++;
                }
            }

            if (countOne > 0) {
                count.add(countOne);
            }
        }

        long ans = 0;

        for (int i = 0; i < count.size() - 1; i++) {
            int freq1 = count.get(i);
            int freq2 = count.get(i + 1);
            long product = (long) freq1 * freq2;

            ans += product;
        }

        return (int) ans;
    }
}

// Approach 2 O(1) Space
class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int m = bank[0].length();
        int prev = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int countOne = 0;

            for (char c : bank[i].toCharArray()) {
                if (c == '1') {
                    countOne++;
                }
            }

            if (countOne > 0) {
                ans += (long) countOne * prev;
                prev = countOne;
            }
        }

        return (int) ans;
    }
}