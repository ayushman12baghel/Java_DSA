import java.util.*;

public class Check_If_A_String_is_a_Subseq_of_Other {

    // Two Pointer
    public static boolean isSubSeq(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return i == n;
    }

    public static void main(String[] args) {
        String s1 = "gksrek", s2 = "geeksforgeeks";

        System.out.println(isSubSeq(s1, s2));
    }
}
