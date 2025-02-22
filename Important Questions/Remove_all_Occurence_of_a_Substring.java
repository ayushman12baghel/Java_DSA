import java.util.*;

public class Remove_all_Occurence_of_a_Substring {

    // Approach 1 Brute Force (n2 * m)
    public static String removeOccurrences(String str, String part) {
        StringBuilder sb = new StringBuilder(str);

        while (true) {
            if (!find(sb, part)) {
                break;
            }
        }

        return sb.toString();
    }

    public static boolean find(StringBuilder sb, String part) {
        int n = sb.length();
        int m = part.length();

        for (int i = 0; i <= n - m; i++) {
            boolean found = true;

            for (int j = 0; j < m; j++) {
                if (sb.charAt(i + j) != part.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                sb.delete(i, i + m);
                return true;
            }
        }

        return false;
    }

    // Approach 2 Using Stack O(n * m)
    public static String removeOccurrences2(String str, String part) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (stack.size() >= part.length() && find(stack, part)) {
                for (int j = 0; j < part.length(); j++) {
                    stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    // Approach 3 Same as Approach 2 but Using StringBuilder as Stack
    public static String removeOccurrences3(String s, String part) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            stack.append(s.charAt(i));

            if (stack.length() >= part.length() && find2(stack, part)) {
                for (int j = 0; j < part.length(); j++) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            }
        }

        return stack.toString();
    }

    public static boolean find2(StringBuilder stack, String part) {
        StringBuilder temp = new StringBuilder(stack);
        int start = stack.length() - 1;

        for (int i = part.length() - 1; i >= 0; i--) {
            if (part.charAt(i) != temp.charAt(start)) {
                return false;
            }
            start--;
        }

        return true;
    }

    public static boolean find(Stack<Character> stack, String part) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stack);

        for (int i = part.length() - 1; i >= 0; i--) {
            if (part.charAt(i) != temp.pop()) {
                return false;
            }
        }

        return true;
    }

    // Approach 4 Using StringBuilder O(n * m)
    public static String removeOccurrences4(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            int index = sb.indexOf(part);
            if (index == -1) {
                return sb.toString();
            }

            sb.delete(index, index + part.length());
        }
    }

    // Approach 4 Using KMP Algorithm O(n*m)
    public static String removeOccurrences5(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int lps[] = computeLPS(part);

        while (true) {
            int check[] = KMP(sb, part, lps);
            if (check[0] == -1) {
                return sb.toString();
            }

            sb.delete(check[1], check[2]);
        }
    }

    public static int[] computeLPS(String pattern) {
        int lps[] = new int[pattern.length()];
        lps[0] = 0;
        int i = 1;
        int length = 0;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
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

        return lps;
    }

    public static int[] KMP(StringBuilder sb, String pattern, int lps[]) {
        int n = sb.length();
        int m = pattern.length();
        int i = 0;
        int j = 0;

        while (i < n) {
            if (sb.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
            if (j == m) {
                return new int[] { 1, i - j, i };
            }
        }

        return new int[] { -1, -1, -1 };
    }

    public static void main(String args[]) {
        String str = "daabcbaabcbc";
        String part = "abc";

        System.out.println(removeOccurrences(str, part));
        System.out.println(removeOccurrences2(str, part));
        System.out.println(removeOccurrences3(str, part));
        System.out.println(removeOccurrences4(str, part));
        System.out.println(removeOccurrences5(str, part));
    }
}
