import java.util.*;

public class KMP_Algorithm {

    public static List<Integer> search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int lps[] = computeLPS(pattern);
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<>();

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    public static int[] computeLPS(String pattern) {
        int lps[] = new int[pattern.length()];
        int length = 0;
        lps[0] = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    lps[i] = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    public static void main(String args[]) {
        String text = "abcab";
        String pattern = "ab";

        System.out.println(search(text, pattern));
    }
}
