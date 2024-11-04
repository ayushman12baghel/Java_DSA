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

    public static void main(String args[]) {
        String str = "aab";

        List<List<String>> list = partition(str);

        for (List<String> l : list) {
            System.out.print(l + " ");
        }
    }
}
