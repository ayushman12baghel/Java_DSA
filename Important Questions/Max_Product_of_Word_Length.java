import java.util.*;

public class Max_Product_of_Word_Length {

    public static int maxProduct(String[] words) {
        int n = words.length;
        int max = 0;
        int mask[] = new int[n];
        for (int i = 0; i < words.length; i++) {
            int currentMask = 0;
            String word = words[i];

            for (int j = 0; j < words[i].length(); j++) {
                currentMask |= 1 << (word.charAt(j) - 'a');
            }

            mask[i] = currentMask;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String words[] = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
        System.out.println(maxProduct(words));
    }
}
