import java.util.*;

public class Neighbouring_Bitwise_Xor {

    // Approach 1
    public static boolean doesValidArrayExist(int derived[]) {
        int n = derived.length;
        int ans[] = new int[n];

        // Case->0;
        ans[0] = 0;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] ^ derived[i - 1];
        }

        if ((ans[0] ^ ans[n - 1]) == derived[n - 1]) {
            return true;
        }

        // Case->1
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] ^ derived[i - 1];
        }

        if ((ans[0] ^ ans[n - 1]) == derived[n - 1]) {
            return true;
        }

        return false;
    }

    // Approach 2 As there is all the characters repeating in xor operation so they
    // all are getting cancelled
    public static boolean doesValidArrayExist2(int derived[]) {
        int xor = 0;

        for (int num : derived) {
            xor = xor ^ num;
        }

        return xor == 0;
    }

    public static void main(String args[]) {
        int derived[] = { 1, 1, 0 };
        System.out.println(doesValidArrayExist(derived));
        System.out.println(doesValidArrayExist2(derived));
    }
}
