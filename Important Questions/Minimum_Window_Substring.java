import java.util.*;

public class Minimum_Window_Substring {

    // O(n+m) Using SlidingWindow
    public static String minWindow(String str, String text) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : text.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int countRequired = text.length();
        int minLength = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int start = 0;
        int end = 0;

        while (j < str.length()) {
            if (map.containsKey(str.charAt(j))) {
                if (map.get(str.charAt(j)) > 0) {
                    countRequired--;
                }

                map.put(str.charAt(j), map.get(str.charAt(j)) - 1);
            }

            while (countRequired == 0) {
                if (j - i + 1 < minLength) {
                    minLength = j - i + 1;
                    start = i;
                    end = j;
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

        return minLength == Integer.MAX_VALUE ? "" : str.substring(start, end + 1);
    }

    public static void main(String args[]) {
        String str = "ADOBECODEBANC";
        String text = "ABC";

        System.out.println(minWindow(str, text));
    }
}
