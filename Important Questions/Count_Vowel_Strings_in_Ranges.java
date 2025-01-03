import java.util.HashSet;
import java.util.Set;

public class Count_Vowel_Strings_in_Ranges {

    public static int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int prefixSum[] = new int[words.length];
        int result[] = new int[queries.length];
        int sum = 0;

        for (int i = 0; i < words.length; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) {
                sum++;
            }

            prefixSum[i] = sum;
        }

        for (int i = 0; i < queries.length; i++) {
            int current[] = queries[i];
            result[i] = prefixSum[current[1]] - (current[0] == 0 ? 0 : prefixSum[current[0] - 1]);
        }

        return result;
    }

    public static void main(String args[]) {
        String words[] = { "aba", "bcb", "ece", "aa", "e" };
        int queries[][] = { { 0, 2 }, { 1, 4 }, { 1, 1 } };

        int ans[] = vowelStrings(words, queries);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}