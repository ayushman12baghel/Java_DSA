import java.util.Arrays;

class Solution {
    int transform(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;

        int[] freq = new int[256];
        for (char c : s1.toCharArray()) freq[c]++;
        for (char c : s2.toCharArray()) freq[c]--;
        for (int x : freq) {
            if (x != 0) return -1;
        }

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int ans = 0;

        while (i >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i--;
                j--;
            } else {
                ans++;
                i--;
            }
        }

        return ans;
    }
}
