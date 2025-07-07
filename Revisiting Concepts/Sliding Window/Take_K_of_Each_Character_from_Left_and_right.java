public class Take_K_of_Each_Character_from_Left_and_right {

    // Approach 1 Using Recursion
    static int ans = Integer.MAX_VALUE;

    public static int takeCharacters(String s, int k) {
        int freq[] = new int[3];

        solve(s, k, 0, s.length() - 1, 0, freq);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void solve(String s, int k, int i, int j, int minutes, int freq[]) {
        if (freq[0] >= k && freq[1] >= k && freq[2] >= k) {
            ans = Math.min(ans, minutes);
            return;
        }

        if (i > j) {
            return;
        }

        int tempLeft[] = freq.clone();
        tempLeft[s.charAt(i) - 'a']++;
        solve(s, k, i + 1, j, minutes + 1, tempLeft);

        int tempRight[] = freq.clone();
        tempRight[s.charAt(j) - 'a']++;
        solve(s, k, i, j - 1, minutes + 1, tempRight);
    }

    // Approach 2 Using SLiding Window O(n)
    public static int takeCharacters2(String s, int k) {
        int n = s.length();
        int count_a = 0;
        int count_b = 0;
        int count_c = 0;

        for (char c : s.toCharArray()) {
            if (c == 'a')
                count_a++;
            if (c == 'b')
                count_b++;
            if (c == 'c')
                count_c++;
        }

        if (count_a < k || count_b < k || count_c < k) {
            return -1;
        }

        int maxDeleted = 0;
        int i = 0;
        int j = 0;

        while (j < n) {
            char current = s.charAt(j);
            if (current == 'a') {
                count_a--;
            } else if (current == 'b') {
                count_b--;
            } else {
                count_c--;
            }

            while (i <= j && (count_a < k || count_b < k || count_c < k)) {
                char move = s.charAt(i);
                if (move == 'a') {
                    count_a++;
                } else if (move == 'b') {
                    count_b++;
                } else {
                    count_c++;
                }

                i++;
            }

            maxDeleted = Math.max(maxDeleted, j - i + 1);

            j++;
        }

        return n - maxDeleted;
    }

    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;

        System.out.println(takeCharacters(s, k));
        System.out.println(takeCharacters2(s, k));
    }
}
