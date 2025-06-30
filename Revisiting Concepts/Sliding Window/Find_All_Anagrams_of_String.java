import java.util.*;

public class Find_All_Anagrams_of_String {

    public static List<Integer> findAnagrams(String str, String pattern) {
        int n = str.length();
        List<Integer> ans = new ArrayList<>();
        int count[] = new int[26];

        for (char c : pattern.toCharArray()) {
            count[c - 'a']++;
        }

        int i = 0;
        int j = 0;

        while (j < n) {
            count[str.charAt(j) - 'a']--;

            if (j - i + 1 == pattern.length()) {
                if (isZero(count)) {
                    ans.add(i);
                }

                count[str.charAt(i) - 'a']++;
                i++;
            }

            j++;
        }

        return ans;
    }

    public static boolean isZero(int count[]) {
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "cbaebabacd";
        String pattern = "abc";

        System.out.println(findAnagrams(str, pattern));
    }
}
