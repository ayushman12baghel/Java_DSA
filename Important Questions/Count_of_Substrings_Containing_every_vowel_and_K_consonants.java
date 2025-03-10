import java.util.*;

public class Count_of_Substrings_Containing_every_vowel_and_K_consonants {

    // Using Sliding Window T.C O(N)
    public static long countOfSubstrings(String word, int k) {
        int n = word.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int consonants = 0;
        long count = 0;
        int nextCons[] = new int[n];
        int prevConsonant = n;

        for (int i = n - 1; i >= 0; i--) {
            nextCons[i] = prevConsonant;
            if (!isVowel(word.charAt(i))) {
                prevConsonant = i;
            }
        }
        while (right < n) {
            char c = word.charAt(right);

            if (isVowel(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else {
                consonants++;
            }

            while (consonants > k) {
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                } else {
                    consonants--;
                }
                left++;
            }

            while (map.size() == 5 && consonants == k) {
                int index = nextCons[right];
                count += index - right;

                if (isVowel(word.charAt(left))) {
                    if (isVowel(word.charAt(left))) {
                        map.put(word.charAt(left), map.get(word.charAt(left)) - 1);
                        if (map.get(word.charAt(left)) == 0) {
                            map.remove(word.charAt(left));
                        }
                    } else {
                        consonants--;
                    }
                }

                left++;
            }

            right++;
        }

        return count;
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static void main(String args[]) {
        String word = "ieaouqqieaouqq";
        int k = 1;

        System.out.println(countOfSubstrings(word, k));
    }
}
