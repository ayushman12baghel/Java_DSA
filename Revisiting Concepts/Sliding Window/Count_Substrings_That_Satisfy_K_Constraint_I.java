import java.util.*;

public class Count_Substrings_That_Satisfy_K_Constraint_I {

    // Approach Using Sliding Window O(n)
    public static int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int oneCount = 0;
        int zeroCount = 0;
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < n) {
            if (s.charAt(j) == '1') {
                oneCount++;
            } else {
                zeroCount++;
            }

            while (oneCount > k && zeroCount > k) {
                if (s.charAt(i) == '1') {
                    oneCount--;
                } else {
                    zeroCount--;
                }

                i++;
            }

            count += (j - i + 1);

            j++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "0101";
        int k = 1;

        System.out.println(countKConstraintSubstrings(s, k));
    }
}
