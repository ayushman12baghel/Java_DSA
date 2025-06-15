import java.util.*;

public class Maximum_Difference_by_remapping_a_Digit {

    public static int minMaxDifference(int num) {
        String max = Integer.toString(num);
        String min = Integer.toString(num);

        int index = 0;

        while (index < max.length() && max.charAt(index) == '9') {
            index++;
        }

        if (index < max.length()) {
            max = max.replace(max.charAt(index), '9');
        }

        min = min.replace(min.charAt(0), '0');

        return Integer.parseInt(max) - Integer.parseInt(min);
    }

    public static void main(String args[]) {
        int num = 11891;

        System.out.println(minMaxDifference(num));
    }
}
