import java.util.*;

class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int i = num1; i <= num2; i++) {
            ans += solve(i);
        }

        return ans;
    }

    public int solve(int n) {
        String s = String.valueOf(n);

        if (s.length() < 3) {
            return 0;
        }

        int total = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            char current = s.charAt(i);
            char prev = s.charAt(i - 1);
            char next = s.charAt(i + 1);

            if (current > prev && current > next) {
                total++;
            } else if (current < prev && current < next) {
                total++;
            }
        }

        return total;
    }
}