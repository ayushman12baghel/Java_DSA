import java.util.*;

public class Number_of_Substrings_Conatining_All_Three_Chars {

    // Using Sliding Window O(N)
    public static int numberOfSubstrings(String str) {
        int n = str.length();
        int i = 0;
        int j = 0;
        int count = 0;
        int freq[] = new int[3];

        while (j < n) {
            char ch = str.charAt(j);
            freq[ch - 'a']++;
            while (hasChar(freq)) {
                char left = str.charAt(i);
                freq[left - 'a']--;
                count += (n - j);
                i++;
            }

            j++;
        }

        return count;
    }

    public static boolean hasChar(int freq[]) {
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }

    public static void main(String args[]) {
        String str = "abcabc";

        System.out.println(numberOfSubstrings(str));
    }
}
