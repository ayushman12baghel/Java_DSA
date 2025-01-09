import java.util.*;

public class Count_Prefix_and_Suffix_Pairs_I {

    public static int countPrefixSuffixPairs(String words[]) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String str1 = words[i];
                String str2 = words[j];

                if (str1.length() > str2.length()) {
                    continue;
                }

                if (str2.startsWith(str1) && str2.endsWith(str1)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String args[]) {
        String words[] = { "a", "aba", "ababa", "aa" };

        System.out.println(countPrefixSuffixPairs(words));
    }
}
