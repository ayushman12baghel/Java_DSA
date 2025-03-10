import java.util.*;

public class Count_of_Substrings_Containing_every_Vowel_and_k_consonents_I {

    // Brute Force T.C O(n^3)
    public static int countOfSubstrings(String word, int k) {
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                if (isValid(word.substring(i, j + 1), k)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isValid(String str, int k) {
        Set<Character> vowelCount = new HashSet<>();
        int consonents = 0;

        for (char c : str.toCharArray()) {
            if (isVowel(c)) {
                vowelCount.add(c);
            } else {
                consonents++;
            }
        }

        return vowelCount.size() == 5 && consonents == k;
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    // Approach 2 Using Sliding Window O(N)
    public static int countOfSubstrings2(String word, int k) {
        int n = word.length();
        int left = 0;
        int right = 0;
        int consonents = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int nextCons[] = new int[n];
        int nextConsonant = n;
        for (int i = n - 1; i >= 0; i--) {
            nextCons[i] = nextConsonant;
            if (!isVowel(word.charAt(i))) {
                nextConsonant = i;
            }
        }

        while (right < n) {
            char c = word.charAt(right);

            if (isVowel(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            } else {
                consonents++;
            }

            while (consonents > k) {
                char leftChar = word.charAt(left);
                if (isVowel(leftChar)) {
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                } else {
                    consonents--;
                }

                left++;
            }

            while (map.size() == 5 && consonents == k) {
                // int index=(right < n - 1) ? nextCons[right] : n;
                int index = nextCons[right];
                count += index - right;
                if (isVowel(word.charAt(left))) {
                    map.put(word.charAt(left), map.get(word.charAt(left)) - 1);
                    if (map.get(word.charAt(left)) == 0) {
                        map.remove(word.charAt(left));
                    }
                } else {
                    consonents--;
                }

                left++;
            }

            right++;
        }

        return count;
    }

    public static void main(String args[]) {
        String word = "ieaouqqieaouqq";
        int k = 1;

        System.out.println(countOfSubstrings(word, k));
    }
}