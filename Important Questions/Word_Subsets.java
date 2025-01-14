import java.util.*;

public class Word_Subsets {

    public static List<String> wordSubsets(String words1[], String words2[]) {
        int count[] = new int[26];
        List<String> ans = new ArrayList<>();

        for (String word : words2) {
            int temp[] = Count(word);

            for (int i = 0; i < 26; i++) {
                count[i] = Math.max(count[i], temp[i]);
            }
        }

        for (String word : words1) {
            int temp[] = Count(word);
            boolean allDone = true;

            for (int i = 0; i < 26; i++) {
                if (count[i] <= temp[i]) {
                    continue;
                } else {
                    allDone = false;
                    break;
                }
            }

            if (allDone) {
                ans.add(word);
            }
        }

        return ans;
    }

    public static int[] Count(String word) {
        int ans[] = new int[26];

        for (char c : word.toCharArray()) {
            ans[c - 'a']++;
        }

        return ans;
    }

    public static void main(String args[]) {
        String words1[] = { "amazon", "apple", "facebook", "google", "leetcode" };
        String words2[] = { "e", "o" };

        System.out.println(wordSubsets(words1, words2));
    }
}
