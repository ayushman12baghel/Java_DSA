public class Number_of_Substrings_With_Only_1s {

    public static int numSub(String str) {
        long ans = 0;
        int mod = 100000007;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                int count = 0;
                while (i < str.length() && str.charAt(i) == '1') {
                    count++;
                    i++;
                }
                ans = ans + ((long) count * (count + 1) / 2) % mod;
            }
        }

        return (int) ans;
    }

    public static void main(String args[]) {
        String str = "0110111";

        System.out.println(numSub(str));
    }
}

// Approach 2 O(n)
class Solution {
    public int numSub(String s) {
        int ans = 0;
        int mod = 1000000007;
        int count1 = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count1++;
                ans = (ans + count1) % mod;
            } else {
                count1 = 0;
            }
        }

        return ans;
    }
}
