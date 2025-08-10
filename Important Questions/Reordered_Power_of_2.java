import java.util.*;

public class Reordered_Power_of_2 {

    // Approach 1
    public static boolean reorderedPowerOf2(int n) {
        String sorted = getSorted(n);

        for (int power = 0; power <= 29; power++) {
            if (sorted.equals(getSorted(1 << power))) {
                return true;
            }
        }

        return false;
    }

    public static String getSorted(int n) {
        char chars[] = String.valueOf(n).toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    public static void main(String[] args) {
        int n = 562;
        System.out.println(reorderedPowerOf2(n));
    }
}
