import java.util.*;

// Approach 1 SlidingWindow O(n)
class Solution {
    public int minFlips(String s) {
        int n = s.length();

        String str = s + s;
        char current = '0';
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (current != s.charAt(i)) {
                count++;
            }

            current = current == '0' ? '1' : '0';
        }

        int ans = count;
        char prev = '0';
        for (int j = n; j < 2 * n; j++) {
            if (prev != str.charAt(j - n)) {
                count--;
            }
            if (current != str.charAt(j)) {
                count++;
            }

            prev = prev == '0' ? '1' : '0';
            current = current == '0' ? '1' : '0';
            ans = Math.min(ans, count);
        }

        current = '1';
        count = 0;

        for (int i = 0; i < n; i++) {
            if (current != s.charAt(i)) {
                count++;
            }

            current = current == '0' ? '1' : '0';
        }

        ans = Math.min(ans, count);
        prev = '1';
        for (int j = n; j < 2 * n; j++) {
            if (prev != str.charAt(j - n)) {
                count--;
            }
            if (current != str.charAt(j)) {
                count++;
            }

            prev = prev == '0' ? '1' : '0';
            current = current == '0' ? '1' : '0';
            ans = Math.min(ans, count);
        }

        return ans;
    }
}

// Approach 2 More Optimised Without Space O(n)
class Solution {
    public int minFlips(String s) {
        int n = s.length();

        int flips1 = 0;
        int flips2 = 0;
        int minFlips = n;
        int i = 0;
        int j = 0;

        while (j < 2 * n) {
            char expected1 = j % 2 == 0 ? '0' : '1';
            char expected2 = j % 2 == 0 ? '1' : '0';

            if (expected1 != s.charAt(j % n)) {
                flips1++;
            }

            if (expected2 != s.charAt(j % n)) {
                flips2++;
            }

            if (j - i + 1 > n) {
                expected1 = i % 2 == 0 ? '0' : '1';
                expected2 = i % 2 == 0 ? '1' : '0';

                if (expected1 != s.charAt(i % n)) {
                    flips1--;
                }

                if (expected2 != s.charAt(i % n)) {
                    flips2--;
                }

                i++;
            }

            if (j - i + 1 == n) {
                minFlips = Math.min(minFlips, Math.min(flips1, flips2));
            }

            j++;
        }

        return minFlips;
    }
}