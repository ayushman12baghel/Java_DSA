import java.util.*;

//Approach (Brute Force All Possible Answers)
//T.C : O(n*k)
//S.C : O(2^k * k), storing 2^k substrings of length k each
class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k)
            return false;

        int uniqueSub = 1 << k;
        HashSet<String> st = new HashSet<>();

        for (int i = k; i <= s.length(); i++) {
            String sub = s.substring(i - k, i);

            if (!st.contains(sub)) {
                st.add(sub);
                uniqueSub--;
            }

            if (uniqueSub == 0)
                return true;
        }

        return false;
    }
}