import java.util.*;

public class Find_The_Kth_Character_in_String_Game_II {

    // Approach Using Recursion
    public static char kthCharacter(long k, int operations[]) {
        if (k == 1) {
            return 'a';
        }

        int n = operations.length;
        long newK = k;
        long length = 1;
        int operationType = -1;

        for (int i = 0; i < n; i++) {
            length *= 2;
            if (length >= k) {
                operationType = operations[i];
                newK = k - length / 2;
                break;
            }
        }

        char result = kthCharacter(newK, operations);
        if (operationType == 0) {
            return result;
        }

        if (result == 'z') {
            return 'a';
        }

        return (char) (result + 1);
    }

    public static void main(String[] args) {
        long k = 10;
        int oprations[] = { 0, 1, 0, 1 };

        System.out.println(kthCharacter(k, oprations));
    }
}
