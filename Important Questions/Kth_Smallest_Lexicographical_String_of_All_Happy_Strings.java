import java.util.*;

public class Kth_Smallest_Lexicographical_String_of_All_Happy_Strings {

    // Approach 1 Using Sorting
    public static String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        solve(list, n, new StringBuilder());
        Collections.sort(list);

        if (k > list.size()) {
            return "";
        }

        return list.get(k - 1);
    }

    public static void solve(List<String> list, int n, StringBuilder current) {
        if (current.length() == n) {
            list.add(current.toString());
            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (current.length() > 0 && current.charAt(current.length() - 1) == c) {
                continue;
            }

            current.append(c);
            solve(list, n, current);
            current.deleteCharAt(current.length() - 1);
        }
    }

    // Approach 2
    public static String getHappyString2(int n, int k) {
        List<String> list = new ArrayList<>();
        solve(list, n, new StringBuilder(), 0);

        if (k > list.size()) {
            return "";
        }

        return list.get(k - 1);
    }

    public static void solve(List<String> list, int n, StringBuilder current, int index) {
        if (index >= n) {
            list.add(current.toString());
            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (index > 0 && current.charAt(index - 1) == c) {
                continue;
            }

            current.append(c);
            solve(list, n, current, index + 1);
            current.deleteCharAt(current.length() - 1);
        }
    }

    // Approach 3 without using unnecessary space
    static int count = 0;

    public static String getHappyString3(int n, int k) {
        StringBuilder ans = new StringBuilder();
        solve(ans, n, new StringBuilder(), 0, k);
        if (k > count) {
            return "";
        }

        return ans.toString();
    }

    public static void solve(StringBuilder ans, int n, StringBuilder current, int index, int k) {
        if (index >= n) {
            count = count + 1;
            if (count == k) {
                ans.append(current.toString());
            }

            return;
        }

        for (char c = 'a'; c <= 'c'; c++) {
            if (index > 0 && current.charAt(index - 1) == c) {
                continue;
            }

            current.append(c);
            solve(ans, n, current, index + 1, k);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String args[]) {
        int n = 3;
        int k = 9;
        System.out.println(getHappyString(n, k));
        System.out.println(getHappyString2(n, k));
        System.out.println(getHappyString3(n, k));
    }
}
