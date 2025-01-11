import java.util.*;

public class Construct_k_Palindrome_Strings {

    public static boolean canConstruct(String str, int k) {
        if (str.length() < k) {
            return false;
        }

        Set<Character> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }

        int oddCount = set.size();

        return oddCount <= k;
    }

    public static void main(String args[]) {
        String str = "annabelle";
        int k = 2;

        System.out.println(canConstruct(str, k));
    }
}
