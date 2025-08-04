import java.util.*;

public class Longest_Repeating_Character_Replacement {

    // Approach Using Sliding Window O(n)
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        int maxFrequency = 0;

        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(j)));

            while ((j - i + 1) - maxFrequency > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }

                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
}
