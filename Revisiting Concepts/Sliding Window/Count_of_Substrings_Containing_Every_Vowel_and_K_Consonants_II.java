import java.util.*;

public class Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II {

    // Sliding Window
    public static long countOfSubstrings(String word, int k) {
        int n = word.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int consonents = 0;
        int nextCons[] = new int[n];
        int nextConsonant = n;
        for (int i = n - 1; i >= 0; i--) {
            nextCons[i] = nextConsonant;
            if (!isVowel(word.charAt(i))) {
                nextConsonant = i;
            }
        }

        int i = 0;
        int j = 0;
        long count = 0;

        while (j < n) {
            char c = word.charAt(j);
            if (isVowel(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else {
                consonents++;
            }

            while (consonents > k) {
                char left = word.charAt(i);
                if (isVowel(left)) {
                    map.put(left, map.get(left) - 1);
                    if (map.get(left) == 0) {
                        map.remove(left);
                    }
                } else {
                    consonents--;
                }

                i++;
            }

            while (i < n && map.size() == 5 && consonents == k) {
                int index = nextCons[j];
                count += (index - j);
                char left = word.charAt(i);
                if (isVowel(left)) {
                    map.put(left, map.get(left) - 1);
                    if (map.get(left) == 0) {
                        map.remove(left);
                    }
                } else {
                    consonents--;
                }

                i++;
            }

            j++;
        }

        return count;
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        String word = "ieaouqqieaouqq";
        int k = 1;

        System.out.println(countOfSubstrings(word, k));
    }
}
