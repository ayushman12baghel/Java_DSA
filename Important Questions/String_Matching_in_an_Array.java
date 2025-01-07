import java.util.*;

public class String_Matching_in_an_Array {

    // Brute force O(n2*m2)
    public static List<String> stringMatching(String words[]) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }

                if (isSubString(words[j], words[i])) {
                    list.add(words[j]);
                }
            }
        }

        return list;
    }

    public static boolean isSubString(String current, String main) {
        for (int i = 0; i < main.length(); i++) {
            boolean substring = true;
            for (int j = 0; j < current.length(); j++) {
                if (i + j >= main.length() || main.charAt(i + j) != current.charAt(j)) {
                    substring = false;
                    break;
                }
            }

            if (substring) {
                return true;
            }
        }

        return false;
    }

    // Optimised using KMP O(n2*m)

    public static List<String> stringMatching2(String words[]) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }

                if (search(words[j], words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }

        return result;
    }

    public static boolean search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int lps[] = computeLPS(pattern);
        int i = 0;
        int j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    return true;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    public static int[] computeLPS(String pattern) {
        int lps[] = new int[pattern.length()];
        lps[0] = 0;
        int length = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String args[]) {
        String words[] = { "mass", "as", "hero", "superhero" };

        System.out.println(stringMatching(words));
        System.out.println(stringMatching2(words));
    }
}
