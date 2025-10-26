import java.util.*;

// Approach 1 O(n)
class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (balanced(i)) {
                return i;
            }
        }

        return -1;
    }

    public boolean balanced(int num) {
        String sb = String.valueOf(num);
        int freq[] = new int[10];

        for (char c : sb.toCharArray()) {
            freq[c - '0']++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                continue;
            } else {
                if (freq[i] != i) {
                    return false;
                }
            }
        }

        return true;
    }
}

// Approach 2 Using Backtracking O(9^count)
class Solution {
    int digits[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    public int nextBeautifulNumber(int n) {
        int count = String.valueOf(n).length();

        int result = backtrack(n, 0, count);
        if (result == 0) {
            result = backtrack(n, 0, count + 1);
        }

        return result;
    }

    public int backtrack(int n, int current, int count) {
        if (count == 0) {
            for (int d = 1; d <= 9; d++) {
                if (digits[d] != 0 && digits[d] != d) {
                    return 0;
                }
            }

            return current > n ? current : 0;
        }

        int result = 0;

        for (int d = 1; d <= 9; d++) {
            if (digits[d] != 0 && digits[d] <= count) {
                digits[d]--;
                result = backtrack(n, current * 10 + d, count - 1);
                digits[d]++;
            }

            if (result != 0) {
                return result;
            }
        }

        return result;
    }
}