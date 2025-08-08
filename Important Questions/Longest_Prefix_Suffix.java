import java.util.*;

public class Longest_Prefix_Suffix {

    public static int getLPSLength(String s) {
        int lps[] = new int[s.length()];
        int length = 0;
        lps[0] = 0;
        int i = 1;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps[s.length() - 1];
    }

    public static void main(String[] args) {
        String s = "aabcdaabc";

        System.out.println(getLPSLength(s));
    }
}
