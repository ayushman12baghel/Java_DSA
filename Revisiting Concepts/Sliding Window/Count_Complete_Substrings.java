import java.util.*;

public class Count_Complete_Substrings {

    // Sliding Window O(n)
    public static int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int left = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (i == n - 1 || Math.abs(word.charAt(i + 1) - word.charAt(i)) > 2) {
                result += solve(word, k, left, i + 1);
                left = i + 1;
            }
        }

        return result;
    }

    public static int solve(String word, int k, int left, int right) {
        int result = 0;

        for (int uniqueChars = 1; uniqueChars <= 26 && uniqueChars * k <= right - left; uniqueChars++) {
            int count[] = new int[26];
            int goodChars = 0; // How many chars of frequency k

            // Now sliding window
            int i = left;
            int j = left;
            int windowLength = uniqueChars * k;

            while (j < right) {
                char ch = word.charAt(j);
                count[ch - 'a']++;

                if (count[ch - 'a'] == k) {
                    goodChars++;
                } else if (count[ch - 'a'] == k + 1) {
                    goodChars--;
                }

                if (j - i + 1 > windowLength) {
                    if (count[word.charAt(i) - 'a'] == k) {
                        goodChars--;
                    } else if (count[word.charAt(i) - 'a'] == k + 1) {
                        goodChars++;
                    }
                    count[word.charAt(i) - 'a']--;
                    i++;
                }

                if (j - i + 1 == windowLength && goodChars == uniqueChars) {
                    result++;
                }

                j++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String word = "aabbbccc";
        int k = 3;

        System.out.println(countCompleteSubstrings(word, k));
    }
}
