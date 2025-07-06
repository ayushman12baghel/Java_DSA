import java.util.*;

public class Permutation_in_String {

    // Approach Using Sliding Window O(n)*26
    public static boolean checkInclusion(String s1, String s2) {
        int n = s2.length();
        int freq[] = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int current[] = new int[26];

        int window = s1.length();
        int i = 0;
        int j = 0;

        while (j < n) {
            current[s2.charAt(j) - 'a']++;

            if (j - i + 1 == window) {
                if (check(freq, current)) {
                    return true;
                }

                current[s2.charAt(i) - 'a']--;
                i++;
            }

            j++;
        }

        return false;
    }

    public static boolean check(int freq1[], int freq2[]) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        System.out.println(checkInclusion(s1, s2));
    }
}
