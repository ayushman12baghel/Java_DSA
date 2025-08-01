import java.util.*;

public class Balancing_Vowels_and_Consonants_Ration {

    // Approach Using PrefixSum and HashMap
    public static int countBalanced(String arr[]) {
        int prefixSum[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            int vowel = 0;
            int consonant = 0;

            for (char ch : str.toCharArray()) {
                if ("aeiou".indexOf(ch) >= 0) {
                    vowel++;
                } else {
                    consonant++;
                }
            }

            prefixSum[i] = vowel - consonant;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for (int i = 0; i < prefixSum.length; i++) {
            sum += prefixSum[i];
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    // More Optimised Without Prefix Table
    public static int countBalanced2(String[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for (String str : arr) {
            int vowel = 0;
            int consonant = 0;

            for (char c : str.toCharArray()) {
                if ("aeiou".indexOf(c) >= 0) {
                    vowel++;
                } else {
                    consonant++;
                }
            }

            sum += (vowel - consonant);
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        String arr[] = { "aeio", "aa", "bc", "ot", "cdbd" };

        System.out.println(countBalanced(arr));
        System.out.println(countBalanced2(arr));
    }
}
