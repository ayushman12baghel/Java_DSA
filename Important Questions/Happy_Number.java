import java.util.*;

public class Happy_Number {

    public static boolean isHappy(int n) {
        int slow = square(n);
        int fast = square(square(n));

        while (slow != fast) {
            slow = square(slow);
            fast = square(square(fast));
        }

        return slow == 1;
    }

    public static int square(int n) {
        int ans = 0;

        while (n > 0) {
            int ld = n % 10;
            ans += ld * ld;
            n /= 10;
        }

        return ans;
    }

    public static boolean isHappy2(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = square(n);
        }

        return true;
    }

    public static void main(String args[]) {
        int n = 19;
        System.out.println(isHappy(n));
        System.out.println(isHappy2(n));
    }
}
