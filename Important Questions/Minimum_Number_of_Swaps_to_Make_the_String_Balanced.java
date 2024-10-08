import java.util.*;

public class Minimum_Number_of_Swaps_to_Make_the_String_Balanced {

    public static int minSwaps(String str) {
        int swaps = 0;
        int balance = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '[') {
                balance++;
            } else {
                balance--;
            }

            if (balance < 0) {
                swaps++;
                balance = 1;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        String str = "]]][[[";

        System.out.println(minSwaps(str));
    }
}
