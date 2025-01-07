import java.util.*;

public class Longest_Palindrome {

    public static int longestPalindrome(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        boolean haveOdd = false;
        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                result += freq;
            } else {
                haveOdd = true;
                result += freq - 1;
            }
        }

        if (haveOdd) {
            result++;
        }

        return result;
    }

    public static int longestPalindrome2(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int oddCount = 0;

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.get(c) % 2 == 0) {
                oddCount--;
            } else {
                oddCount++;
            }
        }

        if (oddCount > 0) {
            return str.length() - oddCount + 1;
        } else {
            return str.length();
        }
    }

    public static int longestPalindrome3(String str) {
        Set<Character> set = new HashSet<>();
        int result = 0;

        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                result += 2;
            } else {
                set.add(c);
            }
        }

        if (!set.isEmpty()) {
            result++;
        }

        return result;
    }

    public static void main(String args[]) {
        String str = "abccccdd";
        System.out.println(longestPalindrome(str));
        System.out.println(longestPalindrome2(str));
        System.out.println(longestPalindrome3(str));
    }
}
