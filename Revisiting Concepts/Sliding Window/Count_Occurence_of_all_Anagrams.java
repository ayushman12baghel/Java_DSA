import java.util.*;

public class Count_Occurence_of_all_Anagrams {

    public static int search(String text, String pattern) {
        int n = text.length();

        int count[] = new int[26];
        for (char c : pattern.toCharArray()) {
            count[c - 'a']++;
        }

        int i = 0;
        int j = 0;
        int ans = 0;

        while (j < n) {
            count[text.charAt(j) - 'a']--;

            if (j - i + 1 == pattern.length()) {
                if (isZero(count)) {
                    ans++;
                }

                count[text.charAt(i) - 'a']++;
                i++;
            }

            j++;
        }

        return ans;
    }

    public static boolean isZero(int count[]) {
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String text = "forxxorfxdofr";

        String pattern = "for";

        System.out.println(search(text, pattern));
    }
}
