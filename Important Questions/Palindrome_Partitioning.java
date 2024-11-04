import java.util.*;

public class Palindrome_Partitioning {

    public static List<List<String>> partition(String str) {
        List<List<String>> ans = new ArrayList<>();
        helper(str, ans, new ArrayList<>());

        return ans;
    }

    public static void helper(String str, List<List<String>> ans, List<String> list) {
        if (str.length() == 0) {
            if (list.size() > 0) {
                ans.add(new ArrayList<>(list));
                return;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str.substring(0, i + 1))) {
                list.add(str.substring(0, i + 1));
                helper(str.substring(i + 1), ans, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static List<List<String>> partition3(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n + 1][n + 1];
        List<List<String>> ans = new ArrayList<>();
        helper3(s, 0, ans, new ArrayList<>(), dp);

        return ans;
    }

    public static void helper3(String str, int start, List<List<String>> ans, List<String> list, boolean dp[][]) {
        if (start == str.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (start > str.length()) {
            return;
        }

        for (int end = start; end < str.length(); end++) {
            if (dp[start][end] || isPalindrome3(str.substring(start, end + 1), dp)) {
                dp[start][end] = true;
                list.add(str.substring(start, end + 1));
                helper3(str, end + 1, ans, list, dp);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome3(String str, boolean dp[][]) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            if (dp[start][end]) {
                return true;
            }
            start++;
            end--;
        }
        return true;
    }

    public static List<List<String>> partition2(String str) {
        int n = str.length();
        boolean dp[][] = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();

        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (str.charAt(start) == str.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                }
            }
        }

        helper2(str, 0, ans, new ArrayList<>(), dp);

        return ans;
    }

    public static void helper2(String str, int start, List<List<String>> ans, List<String> list, boolean dp[][]) {
        if (start == str.length()) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int end = start; end < str.length(); end++) {
            if (dp[start][end]) {
                list.add(str.substring(start, end + 1));
                helper2(str, end + 1, ans, list, dp);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        String str = "aab";

        List<List<String>> list = partition(str);

        for (List<String> l : list) {
            System.out.print(l + " ");
        }
        System.out.println();

        List<List<String>> list2 = partition2(str);

        for (List<String> l : list2) {
            System.out.print(l + " ");
        }
        System.out.println();

        List<List<String>> list3 = partition3(str);

        for (List<String> l : list3) {
            System.out.print(l + " ");
        }
    }
}
