import java.util.*;

public class Longest_Common_Prefix {

    public static String longestCommonPrefix(String strs[]) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            if (prefix.length() == 0) {
                return "";
            }
        }

        return prefix;
    }

    public static String longestCommonPrefix2(String strs[]) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);

        char start[] = strs[0].toCharArray();
        char end[] = strs[strs.length - 1].toCharArray();

        for (int i = 0; i < start.length; i++) {
            if (start[i] != end[i]) {
                break;
            }
            sb.append(start[i]);
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String strs[] = { "flower", "flow", "flight" };

        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix2(strs));
    }
}
