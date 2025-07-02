import java.util.*;

public class Minimum_Window_Substring {

    // Approach 1 Using 2 Windows
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int n = s.length();
        HashMap<Character, Integer> required = new HashMap<>();
        HashMap<Character, Integer> currentWindow = new HashMap<>();
        for (char c : t.toCharArray()) {
            required.put(c, required.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int j = 0;
        String ans = "";
        int minLength = Integer.MAX_VALUE;
        int have = 0;
        int need = required.size();

        while (j < n) {
            currentWindow.put(s.charAt(j), currentWindow.getOrDefault(s.charAt(j), 0) + 1);
            if (required.containsKey(s.charAt(j))) {
                if (currentWindow.get(s.charAt(j)).intValue() == required.get(s.charAt(j)).intValue()) {
                    have++;
                }
            }

            while (have == need) {
                if (j - i + 1 < minLength) {
                    ans = s.substring(i, j + 1);
                    minLength = j - i + 1;
                }

                currentWindow.put(s.charAt(i), currentWindow.get(s.charAt(i)) - 1);
                if (required.containsKey(s.charAt(i)) && currentWindow.get(s.charAt(i)) < required.get(s.charAt(i))) {
                    have--;
                }

                i++;
            }

            j++;
        }

        return ans;
    }

    // Approach 2 Using one Window
    public static String minWindow2(String str, String pattern) {
        int n = str.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : pattern.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;
        int countRequired = pattern.length();
        int minLength = Integer.MAX_VALUE;

        while (j < n) {
            if (map.containsKey(str.charAt(j))) {
                if (map.get(str.charAt(j)) > 0) {
                    countRequired--;
                }

                map.put(str.charAt(j), map.get(str.charAt(j)) - 1);
            }

            while (countRequired == 0) {
                if (minLength > j - i + 1) {
                    start = i;
                    end = j + 1;
                    minLength = j - i + 1;
                }

                if (map.containsKey(str.charAt(i))) {
                    map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
                    if (map.get(str.charAt(i)) > 0) {
                        countRequired++;
                    }
                }

                i++;
            }

            j++;
        }

        return minLength == Integer.MAX_VALUE ? "" : str.substring(start, end);
    }

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String pattern = "ABC";

        System.out.println(minWindow(str, pattern));
        System.out.println(minWindow2(str, pattern));
    }
}
