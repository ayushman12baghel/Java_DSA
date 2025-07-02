import java.util.HashSet;
import java.util.Set;

public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {

    // Approach Using Sliding WIndow
    public static int maxVowels(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int curr = 0;

        while (j < n) {
            if (set.contains(s.charAt(j))) {
                curr++;
            }

            if (j - i + 1 > k) {
                if (set.contains(s.charAt(i))) {
                    curr--;
                }

                i++;
            }
            ans = Math.max(ans, curr);
            j++;
        }

        return ans;
    }

    public static void main(String args[]) {
        String str = "leetcode";
        int k = 3;

        System.out.println(maxVowels(str, k));
    }
}
